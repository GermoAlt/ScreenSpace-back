package com.uade.screenspace.entity;

import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document("reservations")
public class Reservation {

    private Cinema cinema;
    private Screening screening;
    private List<SeatReserved> seatsReserved;
    private User user;

}
