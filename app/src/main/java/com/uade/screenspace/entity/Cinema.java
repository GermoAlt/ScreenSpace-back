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
    private float pricePerFunction;
    @DBRef
    private List<Theater> theaters;
    private List<ScreeningsByDay> screeningsByDay;

    public Cinema(){
        theaters = new ArrayList<>();
    }

    public void addTheater(Theater theater){
        theaters.add(theater);
    }

    public void removeTheater(Theater theater){
        theaters.removeIf(t -> t.getId().equals(theater.getId()));
    }

    public boolean isSameOwner(User user){
        return this.owner.getId().equals(user.getId());
    }
}
