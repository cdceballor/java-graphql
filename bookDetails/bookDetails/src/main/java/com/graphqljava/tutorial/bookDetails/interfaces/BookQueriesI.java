package com.graphqljava.tutorial.bookDetails.interfaces;

import com.graphqljava.tutorial.bookDetails.models.Book;

import java.util.List;

public interface BookQueriesI {
  public Book getById(String id);

  public List<Book> getBooks();

  public void addBook(Book book);
}
