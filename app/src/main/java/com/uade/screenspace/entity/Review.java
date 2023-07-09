package com.uade.screenspace.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.screenspace.model.Comment;
import io.screenspace.model.Rating;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("review")
public class Review {
    private Rating rating;
    private Comment comment;

    public Rating getRating() {
        return rating;
    }

    public void setRating(Rating rating) {
        this.rating = rating;
    }

    public Comment getComment() {
        return comment;
    }

    public void setComment(Comment comment) {
        this.comment = comment;
    }
}
