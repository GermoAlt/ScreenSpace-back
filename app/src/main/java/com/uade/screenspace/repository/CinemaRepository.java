package com.uade.screenspace.repository;

import com.uade.screenspace.entity.Cinema;
import com.uade.screenspace.entity.Theater;
import com.uade.screenspace.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface CinemaRepository extends MongoRepository<Cinema, String> {
    Optional<Cinema> findById(String id);

    Optional<Cinema> findByIdAndOwner(String id, User owner);

    Optional<Cinema> findByTheatersContaining(List<Theater> theaters);
}
