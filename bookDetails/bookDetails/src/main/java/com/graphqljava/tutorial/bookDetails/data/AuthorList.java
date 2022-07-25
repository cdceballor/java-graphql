package com.graphqljava.tutorial.bookDetails.data;

import com.graphqljava.tutorial.bookDetails.models.Author;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AuthorList {

  public static List<Author> authors = new ArrayList<Author>( Arrays.asList(
    new Author("author-1", "Joanne", "Rowling"),
    new Author("author-2", "Herman", "Melville"),
    new Author("author-3", "Anne", "Rice")
  ));
}
