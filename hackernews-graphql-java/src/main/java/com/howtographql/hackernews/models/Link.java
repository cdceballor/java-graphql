package com.howtographql.hackernews.models;

public class Link {

    private final String url;
    private final String description;
    private final String id; //Add the ID to connect us to the database


    public Link(String id, String description, String url) {
        this.id = id;
        this.description = description;
        this.url = url;
    }


    public Link(String description, String url) {
        this(null, description, url);
    }
    
    public String getId() {
        return id;
    }

    public String getUrl() {
        return url;
    }

    public String getDescription() {
        return description;
    }
}