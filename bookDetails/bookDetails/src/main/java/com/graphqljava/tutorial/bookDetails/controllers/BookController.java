package com.graphqljava.tutorial.bookDetails.controllers;

import java.util.List;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

import com.graphqljava.tutorial.bookDetails.models.Author;
import com.graphqljava.tutorial.bookDetails.models.Book;
import com.graphqljava.tutorial.bookDetails.services.AuthorQueries;
import com.graphqljava.tutorial.bookDetails.services.BookQueries;

@Controller
public class BookController {

    final AuthorQueries authorQueries = new AuthorQueries();
    final BookQueries bookQueries = new BookQueries();

    @QueryMapping
    public Book bookById(@Argument String id) {
        return bookQueries.getById(id);
    }

    @QueryMapping
    public List<Book> getBooks() {
        return bookQueries.getBooks();
    }
    
    record InputBook(String id, String name, int pageCount, String authorId) {
    }

    @MutationMapping
    public boolean addBook(@Argument InputBook book) {
        Author author = authorQueries.getById(book.authorId());
        Book newBook = new Book(book.id(), book.name(), book.pageCount(), author.getId());
        System.out.println(newBook.toString());
        System.out.println(bookQueries.addBook(newBook));
        return bookQueries.addBook(newBook);
    }


    @SchemaMapping
    public Author author(Book book) {
        return authorQueries.getById(book.getAuthorId());
    }

}
