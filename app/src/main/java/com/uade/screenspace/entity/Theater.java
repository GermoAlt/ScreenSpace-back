package com.uade.screenspace.entity;

import nonapi.io.github.classgraph.json.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("theaters")
public class Theater {

    @Id
    private String id;
    private String name;
    private boolean temporarilyClosed;
    private SeatsLayout seatsLayout;
    private User user;

    public Theater() {
    }

    public Theater(String name, boolean temporarilyClosed, SeatsLayout seatsLayout) {
        this.name = name;
        this.temporarilyClosed = temporarilyClosed;
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
}
