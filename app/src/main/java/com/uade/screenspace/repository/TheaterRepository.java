package com.uade.screenspace.repository;

import com.uade.screenspace.entity.Theater;
import com.uade.screenspace.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface TheaterRepository extends MongoRepository<Theater, String> {
    Optional<Theater> findById(String id);

    Optional<Theater> findByIdAndUser(String id, User user);
}
