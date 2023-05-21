package com.uade.screenspace.controller;


import com.uade.screenspace.service.UserService;
import io.screenspace.api.UserManagementApiDelegate;
import io.screenspace.model.*;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserController implements UserManagementApiDelegate {

    UserService service;

    @Override
    public ResponseEntity<Void> confirmPasswordReset(InlineObject4 inlineObject4) {
        return null;
    }

    @Override
    public ResponseEntity<InlineResponse201> createUser(UserCreationRequest userCreationRequest) {

        service.createUser(userCreationRequest.getEmail(), userCreationRequest.getPassword(), userCreationRequest.getIsOwner());

        return ResponseEntity.ok(new InlineResponse201().message("success"));
    }

    @Override
    public ResponseEntity<Void> deleteLoggedUser() {
        return null;
    }

    @Override
    public ResponseEntity<Void> forgotPassword(InlineObject2 inlineObject2) {
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
    public ResponseEntity<InlineResponse200> logUser(InlineObject1 inlineObject1) {
        return null;
    }

    @Override
    public ResponseEntity<User> putLoggedUser(User user) {
        return null;
    }

    @Override
    public ResponseEntity<InlineResponse200> refreshAccessToken(InlineObject inlineObject) {
        return null;
    }

    @Override
    public ResponseEntity<Void> resetUserPassword(InlineObject3 inlineObject3) {
        return null;
    }
}
