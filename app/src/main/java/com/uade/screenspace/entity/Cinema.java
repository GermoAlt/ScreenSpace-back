package com.uade.screenspace.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Document("cinemas")
public class Cinema {

    @Id
    private String id;
    private String name;
    private Address address;
    private Geolocation geolocation;
    @DBRef
    private User owner;
    private double pricePerFunction;
    @DBRef
    private List<Theater> theaters;
    private List<ScreeningsByDay> screeningsByDay;

    public Cinema(){
        theaters = new ArrayList<>();
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

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Geolocation getGeolocation() {
        return geolocation;
    }

    public void setGeolocation(Geolocation geolocation) {
        this.geolocation = geolocation;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public double getPricePerFunction() {
        return pricePerFunction;
    }

    public void setPricePerFunction(double pricePerFunction) {
        this.pricePerFunction = pricePerFunction;
    }

    public void setTheaters(List<Theater> theaters) {
        this.theaters = theaters;
    }

    public List<ScreeningsByDay> getScreeningsByDay() {
        return screeningsByDay;
    }

    public void setScreeningsByDay(List<ScreeningsByDay> screeningsByDay) {
        this.screeningsByDay = screeningsByDay;
    }

    public void addTheater(Theater theater){
        theaters.add(theater);
    }

    public void removeTheater(Theater theater){
        theaters.removeIf(t -> t.getId().equals(theater.getId()));
    }

    public List<Theater> getTheaters(){
        return theaters;
    }

    public boolean isSameOwner(User user){
        return this.owner.getId().equals(user.getId());
    }
}
