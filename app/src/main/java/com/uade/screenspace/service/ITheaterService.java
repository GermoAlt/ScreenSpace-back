package com.uade.screenspace.service;

import com.uade.screenspace.entity.Theater;
import com.uade.screenspace.entity.User;

public interface ITheaterService {
    Theater createTheater(io.screenspace.model.Theater theater, String cinemaId, User loggedUser);

    void deleteTheater(String theaterId, User loggedUser);

    Theater findTheater(String theaterId, User loggedUser);
}
