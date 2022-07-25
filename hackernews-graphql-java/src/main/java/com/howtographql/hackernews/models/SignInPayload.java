package com.howtographql.hackernews.models;

public class SignInPayload {
    private final String token;
    private final User user;

    // This class contain a non-scalar value, in other words, a non-primitive value (User), we need to create a resolver

    public SignInPayload(String token, User user) {
        this.token = token;
        this.user = user;
    }

    public String getToken() {
        return token;
    }


    public User getUser() {
        return user;
    }
    

}
