package com.howtographql.hackernews.resolvers;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.howtographql.hackernews.models.SignInPayload;
import com.howtographql.hackernews.models.User;

public class SingInResolver implements GraphQLResolver<SignInPayload> {
    public User user(SignInPayload payload) {
        return payload.getUser();
    }
}
