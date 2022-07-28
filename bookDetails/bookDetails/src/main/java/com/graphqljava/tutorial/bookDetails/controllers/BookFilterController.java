package com.graphqljava.tutorial.bookDetails.controllers;

import java.util.List;

// import org.springframework.graphql.data.method.annotation.QueryMapping;
// import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.graphqljava.tutorial.bookDetails.models.Book;
import com.graphqljava.tutorial.bookDetails.models.BookFilter;
import com.graphqljava.tutorial.bookDetails.services.resolvers.BookResolverQueries;

@Controller
public class BookFilterController implements GraphQLResolver<Book> {

    final BookResolverQueries bookResolverQueries = new BookResolverQueries();

    
    public List<Book> getBooksFiltered(BookFilter bookFilter) {
        System.out.println("Estamos en controller");
        return bookResolverQueries.getBooksFiltered(bookFilter);
    }
}
