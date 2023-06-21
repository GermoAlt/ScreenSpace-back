package com.uade.screenspace.service;

import com.uade.screenspace.entity.Movie;
import com.uade.screenspace.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
        return movieRepository.findById(id).orElse(null);
    }
}
