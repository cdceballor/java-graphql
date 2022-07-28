package com.graphqljava.tutorial.bookDetails.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BookFilter {
    
    private String name_contains;
    private int pageCount_contains;


    public BookFilter(String name_contains, int pageCount_contains) {
        this.name_contains = name_contains;
        this.pageCount_contains = pageCount_contains;
    }

    @JsonProperty("name_contains")
    public String getName_contains() {
        return name_contains;
    }

    public void setName_contains(String name_contains) {
        this.name_contains = name_contains;
    }

    @JsonProperty("pageCount_contains")
    public int getPageCount_contains() {
        return pageCount_contains;
    }

    public void setPageCount_contains(int pageCount_contains) {
        this.pageCount_contains = pageCount_contains;
    }
}
