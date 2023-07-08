package com.uade.screenspace.repository;

import com.uade.screenspace.entity.Movie;
import com.uade.screenspace.entity.Reservation;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface ReservationRepository extends MongoRepository<Reservation, String> {

}
