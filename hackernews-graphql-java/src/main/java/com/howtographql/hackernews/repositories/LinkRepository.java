package com.howtographql.hackernews.repositories;

import static com.mongodb.client.model.Filters.eq;

import com.howtographql.hackernews.interfaces.LinkInterface;
import com.howtographql.hackernews.models.Link;
import com.howtographql.hackernews.models.LinkFilter;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.bson.Document;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;
import static com.mongodb.client.model.Filters.regex;
import static com.mongodb.client.model.Filters.and;

public class LinkRepository implements LinkInterface {

  private final MongoCollection<Document> links;

  // private final List<Link> links; //Creating the list to save the data

  public LinkRepository(MongoCollection<Document> links) {
    // links = new ArrayList<>(); //Creating the structure to save data
    // add some links to start off with|
    // links.add(new Link("http://howtographql.com", "Your favorite GraphQL page"));
    // //Data example
    this.links = links;
  }

  @Override
  public Link findById(String id) {
    Document doc = links.find(eq("id", new ObjectId(id))).first();
    return link(doc);
  }

  @Override
  public List<Link> getAllLinks() {
    List<Link> allLinks = new ArrayList<>();
    for (Document doc : links.find()) {
      allLinks.add(link(doc));
    }
    return allLinks;
  }

  @Override
  public void saveLink(Link link) {
    Document doc = new Document();
    doc.append("url", link.getUrl());
    doc.append("description", link.getDescription());
    links.insertOne(doc);
  }

  private Link link(Document doc) {
    return new Link(
        doc.get("_id").toString(),
        doc.getString("url"),
        doc.getString("description"));
  }

  // Creating the filter implementation to the different links
  @Override
  public List<Link> getAllLinksFilter(LinkFilter filter) {
    Optional<Bson> mongoFilter = Optional.ofNullable(filter).map(this::buildFilter);

    List<Link> allLinks = new ArrayList<>();
    for (Document doc : mongoFilter.map(links::find).orElseGet(links::find)) {
      allLinks.add(link(doc));
    }
    return allLinks;
  }

  @Override
  public List<Link> getAllLinksFilterPagination(LinkFilter filter, int skip, int limit) {
    Optional<Bson> mongoFilter = Optional.ofNullable(filter).map(this::buildFilter);

    List<Link> allLinks = new ArrayList<>();
    FindIterable<Document> documents = mongoFilter.map(links::find).orElseGet(links::find);
    for (Document doc : documents.skip(skip).limit(limit)) {
      allLinks.add(link(doc));
    }
    return allLinks;
  }

  // builds a Bson from a LinkFilter
  private Bson buildFilter(LinkFilter filter) {
    String descriptionPattern = filter.getDescriptionContains();
    String urlPattern = filter.getUrlContains();
    Bson descriptionCondition = null;
    Bson urlCondition = null;
    if (descriptionPattern != null && !descriptionPattern.isEmpty()) {
      descriptionCondition = regex("description", ".*" + descriptionPattern + ".*", "i");
    }
    if (urlPattern != null && !urlPattern.isEmpty()) {
      urlCondition = regex("url", ".*" + urlPattern + ".*", "i");
    }
    if (descriptionCondition != null && urlCondition != null) {
      return and(descriptionCondition, urlCondition);
    }
    return descriptionCondition != null ? descriptionCondition : urlCondition;
  }
}
