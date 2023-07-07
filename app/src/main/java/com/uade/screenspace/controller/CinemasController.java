package com.uade.screenspace.controller;


import com.uade.screenspace.exceptions.EntityNotFound;
import com.uade.screenspace.mapper.CinemaMapper;
import com.uade.screenspace.mapper.ScreeningMapper;
import com.uade.screenspace.service.CinemaService;
import com.uade.screenspace.service.ScreeningService;
import io.screenspace.api.CinemasApi;
import io.screenspace.model.Cinema;
import io.screenspace.model.CreateCinemaRequest;
import io.screenspace.model.Screening;
import io.screenspace.model.UpdateCinemaRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import javax.ws.rs.core.Response;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class CinemasController implements CinemasApi {

    private static final Logger log = LoggerFactory.getLogger(CinemasController.class);

    @Autowired
    CinemaService cinemaService;
    @Autowired
    ScreeningService screeningService;

    public ResponseEntity<List<Cinema>> getCinemas() {
        return ResponseEntity.ok(cinemaService.getCinemas().stream().map(CinemaMapper.INSTANCE::mapToCinemaModel).collect(Collectors.toList()));
    }

    public ResponseEntity<Cinema> createCinema(CreateCinemaRequest request) {
        com.uade.screenspace.entity.Cinema createdCinema = cinemaService.createCinema(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(CinemaMapper.INSTANCE.mapToCinemaModel(createdCinema));
    }

    public ResponseEntity<Cinema> getCinemaById(String cinemaId) {
        com.uade.screenspace.entity.Cinema cinema = cinemaService.getCinemaById(cinemaId);
        if (cinema != null) {
            return ResponseEntity.ok(CinemaMapper.INSTANCE.mapToCinemaModel(cinema));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    public ResponseEntity<Cinema> updateCinemaById(String cinemaId, UpdateCinemaRequest request) {
        com.uade.screenspace.entity.Cinema updatedCinema = cinemaService.updateCinemaById(cinemaId, request);
        if (updatedCinema != null) {
            return ResponseEntity.ok(CinemaMapper.INSTANCE.mapToCinemaModel(updatedCinema));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    public ResponseEntity<Void> deleteCinemaById (String cinemaId) {
        try {
            cinemaService.deleteCinemaById(cinemaId);
            return ResponseEntity.ok().build();
        } catch (EntityNotFound e) {
            return ResponseEntity.notFound().build();
        }
    }

    @Override
    public ResponseEntity<List<Screening>> getScreeningsForCinema(String cinemaId) {
        return ResponseEntity.ok(
                screeningService.screeningsForCinema(cinemaId)
                        .stream()
                        .map(ScreeningMapper::entityToModel).collect(Collectors.toList())
        );
    }
}
