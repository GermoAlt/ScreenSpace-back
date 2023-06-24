package com.uade.screenspace.entity;

import org.joda.time.DateTime;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Document("screenings")
public class Screening {

    @Id
    private String id;
    @DBRef
    private Theater theater;
    @DBRef
    private Movie movie;
    @DBRef
    private Cinema cinema;
    private DateTime date;
    private List<SeatReserved> seatsReserved;

    public Screening() {
        seatsReserved = new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Theater getTheater() {
        return theater;
    }

    public void setTheater(Theater theater) {
        this.theater = theater;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public DateTime getDate() {
        return date;
    }

    public void setDate(DateTime date) {
        this.date = date;
    }

    public List<SeatReserved> getSeatsReserved() {
        return seatsReserved;
    }

    public void setSeatsReserved(List<SeatReserved> seatsReserved) {
        this.seatsReserved = seatsReserved;
    }
}
