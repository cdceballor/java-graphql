package com.graphqljava.tutorial.bookDetails.services.resolvers;

import java.util.List;
import java.util.ArrayList;

import com.graphqljava.tutorial.bookDetails.data.BookList;
import com.graphqljava.tutorial.bookDetails.interfaces.BookFilterQueriesI;
import com.graphqljava.tutorial.bookDetails.models.Book;
import com.graphqljava.tutorial.bookDetails.models.BookFilter;

public class BookResolverQueries implements BookFilterQueriesI {

    public List<Book> getBooksFiltered(BookFilter bookFilter) {
        List<Book> allBooks = new ArrayList<>();
        BookList.books.forEach(book -> {
            if (book.getName().equals(bookFilter.getName_contains())
                    || book.getPageCount() >= bookFilter.getPageCount_contains()) {
                allBooks.add(book);
            }
        });
        return allBooks;
    }
}
