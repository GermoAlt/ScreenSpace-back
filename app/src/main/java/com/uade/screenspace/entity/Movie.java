package com.uade.screenspace.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("movies")
public class Movie {

    @Id
    private String id;

    public Movie() {
        super();
    }
}