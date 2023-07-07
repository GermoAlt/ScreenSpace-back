package com.uade.screenspace.entity;

import org.joda.time.DateTime;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Document("screenings")
public class Screening {

    @Id
    @Indexed
    private String id;
    @Indexed
    @DBRef(lazy = true)
    private Theater theater;
    @Indexed
    @DBRef(lazy = true)
    private Movie movie;
    @Indexed
    @DBRef(lazy = true)
    private Cinema cinema;
    @Indexed
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Screening screening = (Screening) o;
        return id.equals(screening.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
