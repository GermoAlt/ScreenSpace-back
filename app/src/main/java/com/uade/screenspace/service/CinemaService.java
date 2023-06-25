package com.uade.screenspace.service;

import com.uade.screenspace.entity.Cinema;
import com.uade.screenspace.exceptions.EntityNotFound;
import com.uade.screenspace.repository.CinemaRepository;
import io.screenspace.model.CreateCinemaRequest;
import io.screenspace.model.UpdateCinemaRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CinemaService implements ICinemaService{

    @Autowired
    CinemaRepository cinemaRepository;

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
        Cinema cinema = new Cinema();
        cinema.setName(cinemaRequest.getName());
        // Set other properties as needed

        return cinemaRepository.save(cinema);
    }

    @Override
    public Cinema updateCinemaById(String cinemaId, UpdateCinemaRequest cinemaRequest) {
        Cinema cinema = cinemaRepository.findById(cinemaId)
                .orElseThrow(() -> new EntityNotFound("Cinema not found"));

        cinema.setName(cinemaRequest.getName());
        //TO DO: completar
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
