package com.uade.screenspace.entity;

import org.joda.time.DateTime;

import java.util.List;

public class Screening {

    private Theater theater;
    private Movie movie;
    private DateTime date;
    private List<SeatReserved> seatsReserved;

}
