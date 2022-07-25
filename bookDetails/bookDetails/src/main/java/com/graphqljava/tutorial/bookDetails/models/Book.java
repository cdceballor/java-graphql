package com.graphqljava.tutorial.bookDetails.models;

public class Book{
    private String id;
    private String name;
    private int pageCount;
    private String authorId;

    public Book(String id, String name, int pageCount, String authorId) {
        this.id = id;
        this.name = name;
        this.pageCount = pageCount;
        this.authorId = authorId;
    }

    public String getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public int getPageCount() {
        return this.pageCount;
    }

    public String getAuthorId() {
        return this.authorId;
    }

    @Override
    public String toString() {
        return "Book [ id: " + getId()+ ", name "+ getName() + " pageCount: " + getPageCount() + " authorId: " + getAuthorId() + "]";
    }
}