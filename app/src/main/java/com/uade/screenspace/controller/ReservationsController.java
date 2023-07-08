package com.uade.screenspace.controller;

import com.uade.screenspace.mapper.ReservationMapper;
import com.uade.screenspace.service.IReservationService;
import io.screenspace.api.ReservationsApi;
import io.screenspace.model.CreateReservationRequest;
import io.screenspace.model.Reservation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class ReservationsController implements ReservationsApi {

    @Autowired
    IReservationService reservationService;

    @Override
    public ResponseEntity<Reservation> createReservation(@Valid CreateReservationRequest createReservationRequest) {
        var reservation = reservationService.createReservation(createReservationRequest);

        return ResponseEntity.ok(ReservationMapper.entityToModel(reservation));
    }
}
