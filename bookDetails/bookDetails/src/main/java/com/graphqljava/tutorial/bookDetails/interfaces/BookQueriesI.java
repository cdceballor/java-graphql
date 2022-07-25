package com.graphqljava.tutorial.bookDetails.interfaces;

import java.util.List;

import com.graphqljava.tutorial.bookDetails.models.Book;

public interface BookQueriesI {
    public Book getById(String id);
    public List<Book> getBooks();
    public boolean addBook(Book book);
}
