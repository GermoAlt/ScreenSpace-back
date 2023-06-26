package com.uade.screenspace.service;

import com.uade.screenspace.entity.Theater;
import com.uade.screenspace.entity.User;
import com.uade.screenspace.exceptions.EntityNotFound;
import com.uade.screenspace.exceptions.ValidationError;
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

        if (theater.getPricePerFunction() < 0){
            throw new ValidationError("Price per function must be positive");
        }
        if (theater.getSeatsLayout().getNumColumns() < 0 || theater.getSeatsLayout().getNumRows() < 0){
            throw new ValidationError("Seats layout must be positive");
        }

        var cinema = cinemaRepository.findByIdAndOwner(cinemaId, loggedUser).orElseThrow(() -> new EntityNotFound(String.format("Cinema with id %s does not exists", cinemaId)));

        var theaterEntity = TheaterMapper.modelToEntity(theater);
        theaterEntity.setUser(loggedUser);
        theaterEntity.setCinema(cinema);
        var createdTheater = theaterRepository.save(theaterEntity);
        cinema.addTheater(createdTheater);
        cinemaRepository.save(cinema);
        return createdTheater;
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

    @Override
    public List<Theater> findTheatersByCinema(String cinemaId, User loggedUser) {
        return cinemaRepository.findByIdAndOwner(cinemaId, loggedUser)
                .orElseThrow(() -> new EntityNotFound(String.format("Cinema with id %s does not exists", cinemaId)))
                .getTheaters();
    }

    @Override
    public Theater updateTheater(io.screenspace.model.Theater theater, String theaterId, User loggedUser) {
        if (theater.getPricePerFunction() < 0){
            throw new ValidationError("Price per function must be positive");
        }
        if (theater.getSeatsLayout().getNumColumns() < 0 || theater.getSeatsLayout().getNumRows() < 0){
            throw new ValidationError("Seats layout must be positive");
        }
        if(theaterRepository.findByIdAndUser(theaterId, loggedUser).isEmpty()){
            throw new EntityNotFound(String.format("Theater with id %s does not exists", theaterId));
        }
        return theaterRepository.save(TheaterMapper.modelToEntity(theater));
    }
}
