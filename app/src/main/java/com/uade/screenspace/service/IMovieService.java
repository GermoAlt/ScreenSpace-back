package com.uade.screenspace.service;

import com.uade.screenspace.entity.Movie;

import java.util.List;

public interface IMovieService {
    List<Movie> getMoviesByTitle(String title);

    Movie getMovieById(String id);

    List<String> getMovieGenres();
}
