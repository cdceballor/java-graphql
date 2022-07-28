package com.howtographql.hackernews.interfaces;

import java.util.List;

import com.howtographql.hackernews.models.Vote;

public interface VoteInterface {
    public List<Vote> findByUserId(String userId);
    public List<Vote> findByLinkId(String linkId);
    public Vote saveVote(Vote vote);
}
