package com.uade.screenspace.repository;

import com.uade.screenspace.entity.Screening;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface ScreeningRepository extends MongoRepository<Screening, String> {



}
