package com.howtographql.hackernews.services;

import java.util.List;

import com.coxautodev.graphql.tools.GraphQLRootResolver;
import com.howtographql.hackernews.models.Link;
import com.howtographql.hackernews.models.LinkFilter;
import com.howtographql.hackernews.models.User;
import com.howtographql.hackernews.repositories.LinkRepository;
import com.howtographql.hackernews.repositories.UserRepository;

public class Query implements GraphQLRootResolver {

    private final LinkRepository linkRepository;
    private final UserRepository userRepository;
    
    public Query(LinkRepository linkRepository, UserRepository userRepository) {
        this.linkRepository = linkRepository;
        this.userRepository = userRepository;
    }

    public List<Link> allLinks() {
        return linkRepository.getAllLinks();
    }

    public List<Link> allLinksFilter(LinkFilter filter) {
        return linkRepository.getAllLinksFilter(filter);
    }

    // Should the parameters skip and limit be a number because sometimes graphqh-java-tools give us a big integer
    // Now, we're gonna check whats happens if use int
    public List<Link> allLinksFilterPagination(LinkFilter filter, int skip, int limit) {
        return linkRepository.getAllLinksFilterPagination(filter, skip, limit);
    }
    public List<User> allUsers() {
        return userRepository.getAllUsers();
    }
}
