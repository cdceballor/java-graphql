package com.graphqljava.tutorial.bookDetails.services;

import com.graphqljava.tutorial.bookDetails.data.BookList;
import com.graphqljava.tutorial.bookDetails.interfaces.BookQueriesI;
import com.graphqljava.tutorial.bookDetails.models.Book;
import com.graphqljava.tutorial.bookDetails.models.BookFilter;

import java.util.List;
public class BookQueries implements BookQueriesI {

  @Override
  public Book getById(String id) {
    return BookList.books
      .stream()
      .filter(book -> book.getId().equals(id))
      .findFirst()
      .orElse(null);
  }

  @Override
  public List<Book> getBooks() {
    return BookList.books;
  }

  @Override
  public void addBook(Book book) {
    BookList.books.add(book);
  }
}
