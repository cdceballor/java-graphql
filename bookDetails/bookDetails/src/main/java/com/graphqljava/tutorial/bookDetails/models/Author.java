package com.graphqljava.tutorial.bookDetails.models;

public class Author {

    private String id;
    private String firstName;
    private String secondName;

    public Author(String id, String firstName, String secondName) {
        this.id = id;
        this.firstName = firstName;
        this.secondName = secondName;
    }

    public String getId() {
        return this.id;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getsecondName() {
        return this.secondName;
    }
}
