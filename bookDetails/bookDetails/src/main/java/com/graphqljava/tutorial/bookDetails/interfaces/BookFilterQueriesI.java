package com.graphqljava.tutorial.bookDetails.interfaces;

import java.util.List;

import com.graphqljava.tutorial.bookDetails.models.Book;
import com.graphqljava.tutorial.bookDetails.models.BookFilter;

public interface BookFilterQueriesI {
    public List<Book> getBooksFiltered(BookFilter bookFilter);
}
