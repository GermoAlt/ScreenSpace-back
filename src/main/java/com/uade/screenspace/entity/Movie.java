package com.uade.screenspace.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document("movies")
public class Movie {

    @Id
    private String title;
    private String genre;
    private String synopsis;
    private List<Rating> ratings;

    public Movie() {
        super();
    }
}