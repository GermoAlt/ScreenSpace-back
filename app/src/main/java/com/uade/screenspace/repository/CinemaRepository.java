package com.uade.screenspace.repository;

import com.uade.screenspace.entity.Cinema;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CinemaRepository extends MongoRepository<Cinema, String> {

}
