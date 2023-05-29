package com.uade.screenspace.controller;


import com.uade.screenspace.entity.PendingUser;
import com.uade.screenspace.service.IUserService;
import com.uade.screenspace.service.UserService;
import io.screenspace.api.UserManagementApi;
import io.screenspace.api.UserManagementApiDelegate;
import io.screenspace.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController implements UserManagementApi {

    @Autowired
    private UserService service;

    @Override
    public ResponseEntity<Void> confirmPasswordReset(InlineObject4 inlineObject4) {
        return null;
    }

    @Override
    public ResponseEntity<InlineResponse201> createUser(UserCreationRequest userCreationRequest) {
        PendingUser user = service.createPendingUser(userCreationRequest.getEmail(), userCreationRequest.getPassword(), userCreationRequest.getIsOwner());
        return ResponseEntity.ok(new InlineResponse201());
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
