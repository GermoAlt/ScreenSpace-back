package com.uade.screenspace.service;

import com.uade.screenspace.entity.Reservation;
import io.screenspace.model.CreateReservationRequest;

public interface IReservationService {
    Reservation createReservation(CreateReservationRequest createReservationRequest);
}
