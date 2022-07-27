package com.howtographql.hackernews.models;

import java.time.ZonedDateTime;

public class Vote {
    private final String id;
    private final ZonedDateTime createdAt;
    private final String userId;
    private final String linkId;

    public Vote(ZonedDateTime createdAt, String userId, String linkId) {
        this(null, createdAt, userId, linkId);
    }

    public Vote(String id, ZonedDateTime createdAt, String userId, String linkId) {
        this.id = id;
        this.createdAt = createdAt;
        this.userId = userId;
        this.linkId = linkId;
    }


    public String getId() {
        return this.id;
    }


    public ZonedDateTime getCreatedAt() {
        return this.createdAt;
    }


    public String getUserId() {
        return this.userId;
    }


    public String getLinkId() {
        return this.linkId;
    }


}
