package com.uade.screenspace.repository;

import com.uade.screenspace.entity.Movie;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface MovieRepository extends MongoRepository<Movie, String> {

    List<Movie> findByTitleLike(String title);

    Optional<Movie> findById(String id);
}
