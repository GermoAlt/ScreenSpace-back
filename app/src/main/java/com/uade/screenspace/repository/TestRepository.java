package com.uade.screenspace.repository;

import com.uade.screenspace.entity.Movie;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TestRepository extends MongoRepository<Movie, String> {

}
