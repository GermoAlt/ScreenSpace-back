package com.uade.screenspace.service;

import com.uade.screenspace.entity.Theater;
import com.uade.screenspace.entity.User;

import java.util.List;

public interface ITheaterService {
    Theater createTheater(io.screenspace.model.Theater theater, String cinemaId, User loggedUser);

    void deleteTheater(String theaterId, User loggedUser);

    Theater findTheater(String theaterId, User loggedUser);

    List<Theater> findTheatersByCinema(String cinemaId, User loggedUser);

    Theater updateTheater(io.screenspace.model.Theater theater, String theaterID, User loggedUser);
}
