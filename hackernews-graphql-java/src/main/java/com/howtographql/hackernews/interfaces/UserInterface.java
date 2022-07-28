package com.howtographql.hackernews.interfaces;

import java.util.List;

import com.howtographql.hackernews.models.User;

public interface UserInterface {
    public User findByEmail(String email);
    public User findById(String id);
    public User saveUser(User user);
    public List<User> getAllUsers();
}
