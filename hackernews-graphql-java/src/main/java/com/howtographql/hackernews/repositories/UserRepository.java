package com.howtographql.hackernews.repositories;

import static com.mongodb.client.model.Filters.eq;

import java.util.List;

import com.howtographql.hackernews.interfaces.UserInterface;
import com.howtographql.hackernews.models.User;
import com.mongodb.client.MongoCollection;
import org.bson.Document;
import org.bson.types.ObjectId;
import java.util.ArrayList;

public class UserRepository implements UserInterface {

  private final MongoCollection<Document> users;

  public UserRepository(MongoCollection<Document> users) {
    this.users = users;
  }

  @Override
  public User findByEmail(String email) {
    Document doc = users.find(eq("email", email)).first();
    return user(doc);
  }

  @Override
  public User findById(String id) {
    Document doc = users.find(eq("_id", new ObjectId(id))).first();
    return user(doc);
  }

  @Override
  public User saveUser(User user) {
    Document doc = new Document();
    doc.append("name", user.getName());
    doc.append("email", user.getEmail());
    doc.append("password", user.getPassword());
    users.insertOne(doc);
    return new User(
        doc.get("_id").toString(),
        user.getName(),
        user.getEmail(),
        user.getPassword());
  }

  @Override
  public List<User> getAllUsers() {
    List<User> allUsers = new ArrayList<>();
    for (Document doc : users.find()) {
      allUsers.add(user(doc));
    }
    return allUsers;
  }

  private User user(Document doc) {
    if (doc == null) {
      return null;
    }
    return new User(
      doc.get("_id").toString(),
      doc.getString("name"),
      doc.getString("email"),
      doc.getString("password")
    );
  }
}
