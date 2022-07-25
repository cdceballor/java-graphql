package com.howtographql.hackernews;

import javax.servlet.annotation.WebServlet;

import com.coxautodev.graphql.tools.SchemaParser;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;

import graphql.schema.GraphQLSchema;
import graphql.servlet.SimpleGraphQLServlet;

@WebServlet(urlPatterns = "/graphql")
public class GraphQLEndpoint extends SimpleGraphQLServlet {

  private static LinkRepository linkRepository;
  private static UserRepository userRepository;

  static {
    // Change to `new MongoClient("<host>:<port>")`
    // if you don't have Mongo running locally on port 27017
    MongoDatabase mongo = new MongoClient().getDatabase("harckernews");
    linkRepository = new LinkRepository(mongo.getCollection("links"));
    userRepository = new UserRepository(mongo.getCollection("users"));
  }
  
  public GraphQLEndpoint() {
    super(buildSchema());
  }

  private static GraphQLSchema buildSchema() {
    return SchemaParser.newParser()
        .file("schema.graphqls")
        .resolvers(new Query(linkRepository), new Mutation(linkRepository, userRepository))
        .build()
        .makeExecutableSchema();
  }
}