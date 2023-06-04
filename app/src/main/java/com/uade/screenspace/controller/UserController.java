package com.uade.screenspace.controller;


import com.uade.screenspace.entity.PendingUser;
import com.uade.screenspace.service.IUserService;
import com.uade.screenspace.service.UserService;
import io.screenspace.api.UserManagementApi;
import io.screenspace.api.UserManagementApiDelegate;
import io.screenspace.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.neo4j.Neo4jProperties;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
public class UserController  implements UserManagementApi{

    @Autowired
    private IUserService service;
    @Autowired
    AuthenticationManager authManager;

    @Override
    public ResponseEntity<CreateUser201Response> confirmCreateUser(@Valid ConfirmUserCreationRequest confirmUserCreationRequest) {
        service.confirmUserCreation(confirmUserCreationRequest.getEmail(), confirmUserCreationRequest.getToken());
        return ResponseEntity.ok(new CreateUser201Response());
    }

    @Override
    public ResponseEntity<Void> confirmPasswordReset(@Valid ConfirmPasswordResetRequest confirmPasswordResetRequest) {
        return null;
    }

    @Override
    public ResponseEntity<Void> deleteLoggedUser() {
        return null;
    }

    @Override
    public ResponseEntity<Void> forgotPassword(@Valid ForgotPasswordRequest forgotPasswordRequest) {
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
    public ResponseEntity<RefreshAccessToken200Response> logUser(@Valid LogUserRequest logUserRequest) {
        Authentication authentication = authManager.authenticate(new UsernamePasswordAuthenticationToken(logUserRequest.getEmail(), logUserRequest.getPassword()));
        User user = ((User) authentication.getPrincipal());

        return null;
    }

    @Override
    public ResponseEntity<User> putLoggedUser(@Valid User user) {
        return null;
    }

    @Override
    public ResponseEntity<RefreshAccessToken200Response> refreshAccessToken(@Valid RefreshAccessTokenRequest refreshAccessTokenRequest) {
        return null;
    }

    @Override
    public ResponseEntity<Void> resetUserPassword(@Valid ForgotPasswordRequest forgotPasswordRequest) {
        return null;
    }

    @Override
    public ResponseEntity<CreateUser201Response> createUser(UserCreationRequest userCreationRequest) {
        PendingUser user = service.createPendingUser(userCreationRequest.getEmail(), userCreationRequest.getPassword(), userCreationRequest.getIsOwner());
        return ResponseEntity.ok(new CreateUser201Response());
    }

}
