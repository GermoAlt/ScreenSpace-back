package com.uade.screenspace.controller;

import com.uade.screenspace.entity.User;
import com.uade.screenspace.mapper.TheaterMapper;
import com.uade.screenspace.service.ITheaterService;
import io.screenspace.api.TheatersApi;
import io.screenspace.model.Theater;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class TheaterController implements TheatersApi {

    @Autowired
    ITheaterService service;


    @Override
    public ResponseEntity<Theater> createTheater(String cinemaId, @Valid Theater theater) {
        try{
            var createdTheater = service.createTheater(theater, cinemaId, getJWTUser());
            return ResponseEntity.ok(TheaterMapper.entityToModel(createdTheater));
        } catch (Exception e){
            return ResponseEntity.internalServerError().build();
        }
    }

    @Override
    public ResponseEntity<Void> deleteTheaterById(String theaterId) {
        try{
            service.deleteTheater(theaterId, getJWTUser());
            return ResponseEntity.ok(null);
        }  catch (Exception e){
            return ResponseEntity.internalServerError().build();
        }
    }

    @Override
    public ResponseEntity<Theater> getTheatherById(String theaterId) {
        return ResponseEntity.ok(TheaterMapper.entityToModel(service.findTheater(theaterId, getJWTUser())));
    }

    @Override
    public ResponseEntity<List<Theater>> getTheathersForCinema(String cinemaId) {
        return ResponseEntity.ok(
                service.findTheatersByCinema(cinemaId, getJWTUser())
                .stream().map(TheaterMapper::entityToModel)
                .collect(Collectors.toList())
        );
    }

    @Override
    public ResponseEntity<Theater> updateTheaterById(String theaterId, @Valid Theater theater) {
        var updatedTheater = TheaterMapper.entityToModel(service.updateTheater(theater, theaterId, getJWTUser()));
        return ResponseEntity.ok(updatedTheater);
    }

    private User getJWTUser(){
        return ((User) SecurityContextHolder.getContext().getAuthentication().getPrincipal());
    }
}
