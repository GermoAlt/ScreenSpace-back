package com.uade.screenspace.repository;

import com.uade.screenspace.entity.RefreshToken;
import com.uade.screenspace.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface RefreshTokenRepository extends MongoRepository<RefreshToken, String> {
    Optional<RefreshToken> deleteByUserAndJwt(User user, String jwt);

    Optional<RefreshToken> findByJwt(String jwt);
}
