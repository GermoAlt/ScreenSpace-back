package com.uade.screenspace.repository;

import com.uade.screenspace.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface UserRepository extends MongoRepository<User, String> {

    User findByEmailAndPasswordAndIsOwner(String email, String password, Boolean isOwner);

    Optional<User> findByEmail(String email);

    Optional<User> findByEmailAndIsOwner(String email, Boolean isOwner);

    Long  deleteByEmailAndIsOwner(String email, Boolean isOwner);
}
