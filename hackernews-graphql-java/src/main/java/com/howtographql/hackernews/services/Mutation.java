package com.howtographql.hackernews.services;

import com.coxautodev.graphql.tools.GraphQLRootResolver;
import com.howtographql.hackernews.models.AuthData;
import com.howtographql.hackernews.models.Link;
import com.howtographql.hackernews.models.SignInPayload;
import com.howtographql.hackernews.models.User;
import com.howtographql.hackernews.repositories.LinkRepository;
import com.howtographql.hackernews.repositories.UserRepository;

import graphql.GraphQLException;

public class Mutation implements GraphQLRootResolver {
    private final LinkRepository linkRepository;
    private final UserRepository userRepository;

    public Mutation(LinkRepository linkRepository, UserRepository userRepository) {
        this.linkRepository = linkRepository;
        this.userRepository = userRepository;
    }

    public Link createLink(String url, String description) {
        Link newLink = new Link(url, description);
        linkRepository.saveLink(newLink);
        return newLink;
    }

    public User createUser(String name, AuthData auth) {
        User user = new User(name, auth.getEmail(), auth.getPassword());
        return userRepository.saveUser(user);
    }

    // Implementing the resolver of the sign in
    public SignInPayload signInUser(AuthData auth) throws IllegalAccessException {
        User user = userRepository.findByEmail(auth.getEmail());
        if (user.getPassword().equals(auth.getPassword())) {
            return new SignInPayload(user.getId(), user);
        }
        throw new GraphQLException("Invalid credentials");
    }
}
