package com.uade.screenspace.controller;

import com.uade.screenspace.mapper.MovieMapper;
import com.uade.screenspace.service.IMovieService;
import io.screenspace.api.MoviesApi;
import io.screenspace.model.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class MovieController implements MoviesApi {

     @Autowired
    IMovieService movieService;

    @Override
    public ResponseEntity<Movie> getMovieById(String movieId) {
        return ResponseEntity.ok(MovieMapper.entityToModel(movieService.getMovieById(movieId)));
    }

    @Override
    public ResponseEntity<List<Movie>> getMovies(@Valid String movieTitle) {
        var foundMovies = movieService.getMoviesByTitle(movieTitle);
        return ResponseEntity.ok(foundMovies.stream().map(MovieMapper::entityToModel).collect(Collectors.toList()));
    }
}
