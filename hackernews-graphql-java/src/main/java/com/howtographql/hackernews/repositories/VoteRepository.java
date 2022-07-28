package com.howtographql.hackernews.repositories;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

import org.bson.Document;
import com.mongodb.client.MongoCollection;
import com.howtographql.hackernews.interfaces.VoteInterface;
import com.howtographql.hackernews.models.Vote;
import com.howtographql.hackernews.scalar.Scalars;

import static com.mongodb.client.model.Filters.eq;

public class VoteRepository implements VoteInterface {

    private final MongoCollection<Document> votes;

    public VoteRepository(MongoCollection<Document> votes) {
        this.votes = votes;
    }

    @Override
    public List<Vote> findByUserId(String userId) {
        List<Vote> list = new ArrayList<>();
        for (Document doc : votes.find(eq("userId", userId))) {
            list.add(vote(doc));
        }
        return list;
    }

    @Override
    public List<Vote> findByLinkId(String linkId) {
        List<Vote> list = new ArrayList<>();
        for (Document doc : votes.find(eq("linkId", linkId))) {
            list.add(vote(doc));
        }
        return list;
    }

    @Override
    public Vote saveVote(Vote vote) {
        Document doc = new Document();
        doc.append("userId", vote.getUserId());
        doc.append("linkId", vote.getLinkId());
        doc.append("createdAt", Scalars.dateTime.getCoercing().serialize(vote.getCreatedAt()));
        votes.insertOne(doc);
        return new Vote(
                doc.get("_id").toString(),
                vote.getCreatedAt(),
                vote.getUserId(),
                vote.getLinkId());
    }

    private Vote vote(Document doc) {
        return new Vote(
                doc.get("_id").toString(),
                ZonedDateTime.parse(doc.getString("createdAt")),
                doc.getString("userId"),
                doc.getString("linkId"));
    }
}
