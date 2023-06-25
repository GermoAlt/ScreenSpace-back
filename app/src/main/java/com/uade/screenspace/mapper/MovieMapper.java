package com.uade.screenspace.mapper;

import com.uade.screenspace.entity.Movie;

public class MovieMapper {

    public static Movie modelToEntity(io.screenspace.model.Movie model){
        Movie modelMovie = new Movie();

        return modelMovie;
    }

    public static io.screenspace.model.Movie entityToModel(Movie entityMovie){
        return new io.screenspace.model.Movie()
                .duration(entityMovie.getDuration().toString())
                .image(entityMovie.getBase64Image())
                .rating(5D)
                .synopsis(entityMovie.getSynopsis())
                .title(entityMovie.getTitle())
                .genre(entityMovie.getGenre())
                .id(entityMovie.getId());
    }
}
