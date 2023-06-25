package com.uade.screenspace.service;

import com.uade.screenspace.entity.Cinema;
import com.uade.screenspace.exceptions.DuplicatedEntity;
import com.uade.screenspace.exceptions.EntityNotFound;
import com.uade.screenspace.mapper.CinemaMapper;
import com.uade.screenspace.repository.CinemaRepository;
import io.screenspace.model.CreateCinemaRequest;
import io.screenspace.model.UpdateCinemaRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CinemaService implements ICinemaService{

    @Autowired
    CinemaRepository cinemaRepository;
    @Autowired
    CinemaMapper cinemaMapper;

    @Override
    public List<Cinema> getCinemas() {
        return cinemaRepository.findAll();
    }

    @Override
    public Cinema getCinemaById(String cinemaId) {
        return cinemaRepository.findById(cinemaId)
                .orElseThrow(() -> new EntityNotFound("Cinema not found"));
    }

    @Override
    public Cinema createCinema(CreateCinemaRequest cinemaRequest) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Cinema cinema = CinemaMapper.INSTANCE.mapCreateCinemaRequestToCinema(cinemaRequest, authentication.getPrincipal());
        if (cinemaRepository.existsByName(cinema.getName())) {
            throw new DuplicatedEntity("Cinema with the same name already exists");
        }
        return cinemaRepository.save(cinema);
    }

    @Override
    public Cinema updateCinemaById(String cinemaId, UpdateCinemaRequest cinemaRequest) {
        Cinema cinema = cinemaRepository.findById(cinemaId)
                .orElseThrow(() -> new EntityNotFound("Cinema not found"));
        CinemaMapper.INSTANCE.mapCreateCinemaToUpdateCinema(cinemaRequest);
        return cinemaRepository.save(cinema);
    }

    @Override
    public boolean deleteCinemaById(String cinemaId) {
        if (!cinemaRepository.existsById(cinemaId)) {
            throw new EntityNotFound("Cinema not found");
        }
        cinemaRepository.deleteById(cinemaId);
        return false;
    }
}
