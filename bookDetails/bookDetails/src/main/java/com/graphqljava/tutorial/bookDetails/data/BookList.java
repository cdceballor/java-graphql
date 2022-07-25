package com.graphqljava.tutorial.bookDetails.data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.graphqljava.tutorial.bookDetails.models.Book;

public class BookList {
    
    public static List<Book> books = new ArrayList<Book>(Arrays.asList(
            new Book("book-1", "Harry Potter and the Philosopher's Stone", 223, "author-1"),
            new Book("book-2", "Moby Dick", 635, "author-2"),
            new Book("book-3", "Interview with the vampire", 371, "author-3")));

}