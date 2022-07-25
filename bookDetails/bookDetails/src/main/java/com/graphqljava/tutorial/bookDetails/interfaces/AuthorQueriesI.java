package com.graphqljava.tutorial.bookDetails.interfaces;

import java.util.List;

import com.graphqljava.tutorial.bookDetails.models.Author;

public interface AuthorQueriesI {
    public Author getById(String id);
    public List<Author> getAuthors();
}
