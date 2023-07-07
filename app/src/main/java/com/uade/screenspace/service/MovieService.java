package com.uade.screenspace.service;

import com.uade.screenspace.entity.Movie;
import com.uade.screenspace.exceptions.EntityNotFound;
import com.uade.screenspace.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class MovieService implements IMovieService{

    @Autowired
    MovieRepository movieRepository;

    @Override
    public List<Movie> getMoviesByTitle(String title) {
        if (title != null && !title.isBlank())
            return movieRepository.findByTitleLike(title);
        else
            return movieRepository.findAll();
    }

    @Override
    public Movie getMovieById(String id) {
        return movieRepository.findById(id).orElseThrow(() -> new EntityNotFound(String.format("Movie with id %s does not exists", id)));
    }

    @Override
    public List<String> getMovieGenres() {
        return movieRepository.findAll().stream().map(Movie::getGenre).flatMap(List::stream).distinct().collect(Collectors.toList());
    }
}
