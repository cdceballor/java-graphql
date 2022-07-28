package com.howtographql.hackernews.db;

import com.howtographql.hackernews.repositories.LinkRepository;
import com.howtographql.hackernews.repositories.UserRepository;
import com.howtographql.hackernews.repositories.VoteRepository;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;

public class MongoDBConnector {

    public void connect(
            MongoDatabase mongo, LinkRepository linkRepository, UserRepository userRepository,VoteRepository voteRepository) {

        // MongoDatabase mongo = new MongoClient().getDatabase("harckernews");
        linkRepository = new LinkRepository(mongo.getCollection("links"));
        userRepository = new UserRepository(mongo.getCollection("users"));
        voteRepository = new VoteRepository(mongo.getCollection("votes"));
    }


}
