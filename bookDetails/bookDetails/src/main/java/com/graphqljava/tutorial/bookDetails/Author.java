package com.graphqljava.tutorial.bookDetails;

import java.util.Arrays;
import java.util.List;

public class Author {

    private String id;
    private String firstName;
    private String secondName;

    public Author(String id, String firstName, String secondName) {
        this.id = id;
        this.firstName = firstName;
        this.secondName = secondName;
    }

    private static List<Author> authors = Arrays.asList(
        new Author("author-1", "Joanne", "Rowling"),
        new Author("author-2", "Herman", "Melville"),
        new Author("author-3", "Anne", "Rice")
    );

    public static Author getById(String id) {
        return authors.stream().filter(author -> author.getId().equals(id)).findFirst().orElse(null);
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
