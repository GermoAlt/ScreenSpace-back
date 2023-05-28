package com.uade.screenspace.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "pendingUsers")
public class PendingUser {

    public PendingUser(User pendingUser, Code code) {
        this.pendingUser = pendingUser;
        this.code = code;
    }

    @Id
    private String id;
    private User pendingUser;
    private Code code;

    public String getId() {
        return id;
    }

    public User getPendingUser() {
        return pendingUser;
    }

    public Code getCode() {
        return code;
    }
}
