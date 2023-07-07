package com.uade.screenspace.entity;

import nonapi.io.github.classgraph.json.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Objects;

@Document("theaters")
public class Theater {

    @Id
    private String id;
    private String name;
    private boolean temporarilyClosed;
    private SeatsLayout seatsLayout;
    private double pricePerFunction;
    @DBRef
    private Cinema cinema;
    @DBRef
    private User user;

    public Theater() {
    }

    public Theater(String name, boolean temporarilyClosed, double pricePerFunction, SeatsLayout seatsLayout) {
        this.name = name;
        this.temporarilyClosed = temporarilyClosed;
        this.pricePerFunction = pricePerFunction;
        this.seatsLayout = seatsLayout;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isTemporarilyClosed() {
        return temporarilyClosed;
    }

    public void setTemporarilyClosed(boolean temporarilyClosed) {
        this.temporarilyClosed = temporarilyClosed;
    }

    public SeatsLayout getSeatsLayout() {
        return seatsLayout;
    }

    public void setSeatsLayout(SeatsLayout seatsLayout) {
        this.seatsLayout = seatsLayout;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public double getPricePerFunction() {
        return pricePerFunction;
    }

    public void setPricePerFunction(double pricePerFunction) {
        this.pricePerFunction = pricePerFunction;
    }

    public Cinema getCinema() {
        return cinema;
    }

    public void setCinema(Cinema cinema) {
        this.cinema = cinema;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Theater theater = (Theater) o;
        return id.equals(theater.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
