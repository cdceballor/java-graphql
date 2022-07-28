package com.graphqljava.tutorial.bookDetails.services;

import java.util.List;

import com.graphqljava.tutorial.bookDetails.data.AuthorList;
import com.graphqljava.tutorial.bookDetails.interfaces.AuthorQueriesI;
import com.graphqljava.tutorial.bookDetails.models.Author;

public class AuthorQueries implements AuthorQueriesI {
    
    @Override
    public Author getById(String id) {
        return AuthorList.authors.stream().filter(author -> author.getId().equals(id)).findFirst().orElse(null);
    }
    @Override
    public List<Author> getAuthors() {
        return AuthorList.authors;
    }
    @Override
    public Author saveAuthor(Author author) {
        AuthorList.authors.add(author);
        return author;
    }
}
