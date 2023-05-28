package com.uade.screenspace.repository;

import com.uade.screenspace.entity.PendingUser;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PendingUserRepository extends MongoRepository<PendingUser, String> {
}
