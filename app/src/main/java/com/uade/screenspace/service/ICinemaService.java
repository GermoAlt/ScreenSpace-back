package com.uade.screenspace.service;

import com.uade.screenspace.entity.Cinema;
import io.screenspace.model.CreateCinemaRequest;
import io.screenspace.model.UpdateCinemaRequest;

import java.util.List;

public interface ICinemaService {
    List<Cinema> getCinemas();
    Cinema createCinema(CreateCinemaRequest request);
    Cinema getCinemaById(String cinemaId);
    Cinema updateCinemaById(String cinemaId, UpdateCinemaRequest request);
    boolean deleteCinemaById(String cinemaId);
}
