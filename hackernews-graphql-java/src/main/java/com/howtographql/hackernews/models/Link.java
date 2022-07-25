package com.howtographql.hackernews.models;

public class Link {

    private final String url;
    private final String description;
    private final String id; //Add the ID to connect us to the database


    public Link(String url, String description, String id) {
        this.url = url;
        this.description = description;
        this.id = id;
    }


    public Link(String url, String description) {
        this(null, url, description);
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