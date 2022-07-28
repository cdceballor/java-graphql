package com.howtographql.hackernews.controllers;

import com.coxautodev.graphql.tools.SchemaParser;
// import com.howtographql.hackernews.db.MongoDBConnector;
import com.howtographql.hackernews.error.SanitizedError;
import com.howtographql.hackernews.repositories.LinkRepository;
import com.howtographql.hackernews.repositories.UserRepository;
import com.howtographql.hackernews.repositories.VoteRepository;
import com.howtographql.hackernews.resolvers.SingInResolver;
import com.howtographql.hackernews.resolvers.VoteResolver;
import com.howtographql.hackernews.scalar.Scalars;
import com.howtographql.hackernews.services.Mutation;
import com.howtographql.hackernews.services.Query;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;
import graphql.schema.GraphQLSchema;
import graphql.servlet.SimpleGraphQLServlet;

import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.annotation.WebServlet;

import graphql.ExceptionWhileDataFetching;
import graphql.GraphQLError;

@WebServlet(urlPatterns = "/graphql")
public class GraphQLEndpoint extends SimpleGraphQLServlet {

  private static LinkRepository linkRepository;
  private static UserRepository userRepository;
  private static VoteRepository voteRepository;
  
  static {
    // Change to `new MongoClient("<host>:<port>")`
    // if you don't have Mongo running locally on port 27017
    MongoDatabase mongo = new MongoClient().getDatabase("harckernews");
    linkRepository = new LinkRepository(mongo.getCollection("links"));
    userRepository = new UserRepository(mongo.getCollection("users"));
    voteRepository = new VoteRepository(mongo.getCollection("votes"));
    // MongoDBConnector mongodb = new MongoDBConnector();
    // mongodb.connect(mongo, linkRepository, userRepository, voteRepository);
  }

  public GraphQLEndpoint() {
    super(buildSchema());
  }

  @Override
  protected List<GraphQLError> filterGraphQLErrors(List<GraphQLError> errors) {
    return errors.stream()
        .filter(e -> e instanceof ExceptionWhileDataFetching || super.isClientError(e))
        .map(e -> e instanceof ExceptionWhileDataFetching ? new SanitizedError((ExceptionWhileDataFetching) e) : e)
        .collect(Collectors.toList());
  }

  private static GraphQLSchema buildSchema() {
    return SchemaParser
        .newParser()
        .file("schema.graphqls")
        .resolvers(
            new Query(linkRepository, userRepository),
            new Mutation(linkRepository, userRepository, voteRepository),
            new SingInResolver(),
            new VoteResolver(linkRepository, userRepository)) // new resolver
        .scalars(Scalars.dateTime)
        .build()
        .makeExecutableSchema();
  }
}
