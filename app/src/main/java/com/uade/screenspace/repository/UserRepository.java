package com.uade.screenspace.repository;

import com.uade.screenspace.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {
}
