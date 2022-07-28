package com.howtographql.hackernews.interfaces;

import java.util.List;

import com.howtographql.hackernews.models.Link;
import com.howtographql.hackernews.models.LinkFilter;

public interface LinkInterface {

    public Link findById(String id);
    public List<Link> getAllLinks();
    public void saveLink(Link link);
    public List<Link> getAllLinksFilter(LinkFilter link);
    public List<Link> getAllLinksFilterPagination(LinkFilter filter, int skip, int limit);
}
