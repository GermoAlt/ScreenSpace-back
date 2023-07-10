package com.uade.screenspace.entity;


import org.springframework.data.mongodb.core.mapping.Document;

@Document("review")
public class Review {
    private Rating rating;
    private Comment comment;
    private String movieId;

    public String getMovieId() {
        return movieId;
    }

    public void setMovieId(String movieId) {
        this.movieId = movieId;
    }

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
