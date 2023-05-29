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

import javax.validation.Valid;
import java.util.List;

@RestController
public class UserController  implements UserManagementApi{

    @Autowired
    private UserService service;

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
