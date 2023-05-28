package com.uade.screenspace.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Document(collection = "users")
public class User {

    @Id
    private String id;
    private String email;
    private String password;
    private Boolean isOwner;
    private String profilePicUrl;
    private List<Code> codes;

    public User(String email, String password, Boolean isOwner, String profilePicUrl) {
        this.email = email;
        this.password = password;
        this.isOwner = isOwner;
        this.profilePicUrl = profilePicUrl;
        this.codes = new ArrayList<>();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getOwner() {
        return isOwner;
    }

    public void setOwner(Boolean owner) {
        isOwner = owner;
    }

    public String getProfilePicUrl() {
        return profilePicUrl;
    }

    public void setProfilePicUrl(String profilePicUrl) {
        this.profilePicUrl = profilePicUrl;
    }

    public String getId() {
        return id;
    }

    public List<Code> getCodes() {
        return codes;
    }

    public void addPasswordResetCode(Code code){
        codes.add(code);
    }
}
