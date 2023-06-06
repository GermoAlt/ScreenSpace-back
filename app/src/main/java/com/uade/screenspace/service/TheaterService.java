package com.uade.screenspace.service;

import com.uade.screenspace.entity.Theater;
import com.uade.screenspace.entity.User;
import com.uade.screenspace.exceptions.EntityNotFound;
import com.uade.screenspace.mapper.TheaterMapper;
import com.uade.screenspace.repository.CinemaRepository;
import com.uade.screenspace.repository.TheaterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TheaterService implements ITheaterService {

    @Autowired
    CinemaRepository cinemaRepository;
    @Autowired
    TheaterRepository theaterRepository;

    @Override
    public Theater createTheater(io.screenspace.model.Theater theater, String cinemaId, User loggedUser) {
        var cinema = cinemaRepository.findByIdAndOwner(cinemaId, loggedUser).orElseThrow(() -> new EntityNotFound(String.format("Cinema with id %s does not exists", cinemaId)));

        var theaterEntity = TheaterMapper.modelToEntity(theater);
        theaterEntity.setUser(loggedUser);
        cinema.addTheater(theaterEntity);
        theaterRepository.save(theaterEntity);
        cinemaRepository.save(cinema);
        return theaterEntity;
    }

    @Override
    public void deleteTheater(String theaterId, User loggedUser) {
        var theater = theaterRepository.findById(theaterId).orElseThrow(() -> new EntityNotFound(String.format("Theater with id %s does not exists", theaterId)));
        var cinema = cinemaRepository.findByTheatersContaining(List.of(theater)).get();

        if(!cinema.isSameOwner(loggedUser)){
            throw new EntityNotFound(String.format("Theater with id %s does not exists", theaterId));
        }

        cinema.removeTheater(theater);
        theaterRepository.delete(theater);
        cinemaRepository.save(cinema);
    }

    @Override
    public Theater findTheater(String theaterId, User loggedUser) {
        return theaterRepository.findByIdAndUser(theaterId, loggedUser).orElseThrow(() -> new EntityNotFound(String.format("Theater with id %s does not exists", theaterId)));
    }
}
