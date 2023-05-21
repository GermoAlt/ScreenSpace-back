package com.uade.screenspace.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document("cinemas")
public class Cinema {

    @Id
    private String name;
    private Address address;
    private Geolocation geolocation;
    private User owner;
    private float pricePerFunction;
    private List<Screen> screens;
    private List<ScreeningsByDay> screeningsByDay;



}
