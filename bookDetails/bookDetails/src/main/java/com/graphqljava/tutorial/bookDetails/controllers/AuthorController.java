package com.graphqljava.tutorial.bookDetails.controllers;

import java.util.List;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import com.graphqljava.tutorial.bookDetails.models.Author;
import com.graphqljava.tutorial.bookDetails.services.AuthorQueries;

@Controller
public class AuthorController {

    final AuthorQueries authorQueries = new AuthorQueries();
    
    @QueryMapping
    public Author authorById(@Argument String id) {
        return authorQueries.getById(id);
    }

    @QueryMapping
    public List<Author> getAuthors() {
        return authorQueries.getAuthors();
    }
}
