package com.uade.screenspace.controller;


import io.screenspace.api.UserManagementApi;
import io.screenspace.model.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController implements UserManagementApi {

    @RequestMapping("/goodbye")
    public String helloWorld(){
        return "Goodbye from Spring Boot";
    }

    @Override
    public ResponseEntity<Void> confirmPasswordReset(@javax.validation.Valid InlineObject4 inlineObject4) {
        return null;
    }

    @Override
    public ResponseEntity<InlineResponse201> createUser(@javax.validation.Valid UserCreationRequest userCreationRequest) {
        return null;
    }

    @Override
    public ResponseEntity<Void> deleteLoggedUser() {
        return null;
    }

    @Override
    public ResponseEntity<Void> forgotPassword(@javax.validation.Valid InlineObject2 inlineObject2) {
        return null;
    }

    @Override
    public ResponseEntity<List<User>> getLoggedUser() {
        return null;
    }

    @Override
    public ResponseEntity<Void> logOutUser() {
        return null;
    }

    @Override
    public ResponseEntity<InlineResponse200> logUser(@javax.validation.Valid InlineObject1 inlineObject1) {
        return null;
    }

    @Override
    public ResponseEntity<User> putLoggedUser(@javax.validation.Valid User user) {
        return null;
    }

    @Override
    public ResponseEntity<InlineResponse200> refreshAccessToken(@javax.validation.Valid InlineObject inlineObject) {
        return null;
    }

    @Override
    public ResponseEntity<Void> resetUserPassword(@javax.validation.Valid InlineObject3 inlineObject3) {
        return null;
    }
}
