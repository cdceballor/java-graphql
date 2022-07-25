package com.howtographql.hackernews;

import static com.mongodb.client.model.Filters.eq;

import com.mongodb.client.MongoCollection;
import java.util.ArrayList;
import java.util.List;
import org.bson.Document;
import org.bson.types.ObjectId;

public class LinkRepository {

  private final MongoCollection<Document> links;

  // private final List<Link> links; //Creating the list to save the data

  public LinkRepository(MongoCollection<Document> links) {
    // links = new ArrayList<>(); //Creating the structure to save data
    // add some links to start off with|
    // links.add(new Link("http://howtographql.com", "Your favorite GraphQL page")); //Data example
    this.links = links;
  }

  public Link findById(String id) {
    Document doc = links.find(eq("_id", new ObjectId(id))).first();
    return link(doc);
  }

  public List<Link> getAllLinks() {
    List<Link> allLinks = new ArrayList<>();
    for (Document doc : links.find()) {
      allLinks.add(link(doc));
    }
    return allLinks;
  }

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
      doc.getString("description")
    );
  }
}
