package com.uade.screenspace.controller;


import com.uade.screenspace.entity.PendingUser;
import com.uade.screenspace.entity.RefreshToken;
import com.uade.screenspace.exceptions.EntityNotFound;
import com.uade.screenspace.mapper.UserMapper;
import com.uade.screenspace.service.IAuthService;
import com.uade.screenspace.service.IUserService;
import io.screenspace.api.UserManagementApi;
import io.screenspace.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class UserController  implements UserManagementApi{

    @Autowired
    private IUserService service;
    @Autowired
    IAuthService authService;
    @Autowired
    AuthenticationManager authManager;

    @Override
    public ResponseEntity<CreateUser201Response> confirmCreateUser(@Valid ConfirmUserCreationRequest confirmUserCreationRequest) {
        service.confirmUserCreation(confirmUserCreationRequest.getEmail(), confirmUserCreationRequest.getToken());
        return ResponseEntity.ok(new CreateUser201Response());
    }

    @Override
    public ResponseEntity<Void> deleteLoggedUser() {
        service.deleteUser(getJWTUser());
        return ResponseEntity.ok(null);
    }

    @Override
    public ResponseEntity<User> getLoggedUser() {
        var user = service.findUserById(getJWTUser().getId());
        return ResponseEntity.ok(UserMapper.entityToModel(user));
    }

    @Override
    public ResponseEntity<Void> logOutUser() {
        authService.deleteSession(getJWTUser(), getUsedTokenInHeader());
        return ResponseEntity.ok(null);
    }

    @Override
    public ResponseEntity<LoginResponse> logUser(@Valid LogUserRequest logUserRequest) {
        Authentication authentication;
        try {
            authentication = authManager.authenticate(new UsernamePasswordAuthenticationToken(logUserRequest.getEmail(), logUserRequest.getPassword()));
        } catch (BadCredentialsException e){
            throw new EntityNotFound("No user found with the credentials provided");
        }
        com.uade.screenspace.entity.User user = ((com.uade.screenspace.entity.User) authentication.getPrincipal());

        RefreshToken token = authService.getToken(user, true);

        LoginResponse response = new LoginResponse().token(token.getJwt()).refreshToken(token.getRefreshToken());

        return ResponseEntity.ok(response);
    }

    @Override
    public ResponseEntity<LoginResponse> logUserWithOauth(@Valid LogUserWithOauthRequest logUserWithOauthRequest) {

        com.uade.screenspace.entity.User user = service.findOrCreateOauthUser(logUserWithOauthRequest.getEmail());

        RefreshToken token = authService.getToken(user, false);

        LoginResponse response = new LoginResponse().token(token.getJwt()).refreshToken(token.getRefreshToken());

        return ResponseEntity.ok(response);
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
    public ResponseEntity<Void> resetUserPassword(@Valid ResetUserPasswordRequest resetUserPasswordRequest) {
        service.confirmPasswordReset(resetUserPasswordRequest.getEmail(), resetUserPasswordRequest.getToken());
        return ResponseEntity.ok(null);
    }

    @Override
    public ResponseEntity<Void> forgotPassword(@Valid ForgotPasswordRequest forgotPasswordRequest) {
        service.passwordReset(forgotPasswordRequest.getEmail());
        return ResponseEntity.ok(null);
    }

    @Override
    public ResponseEntity<Void> confirmPasswordReset(@Valid ConfirmPasswordResetRequest confirmPasswordResetRequest) {
        service.updatePassword(confirmPasswordResetRequest.getEmail(), confirmPasswordResetRequest.getPassword(), confirmPasswordResetRequest.getCode());
        return ResponseEntity.ok(null);
    }

    @Override
    public ResponseEntity<CreateUser201Response> createUser(UserCreationRequest userCreationRequest) {
        PendingUser user = service.createPendingUser(userCreationRequest.getEmail(), userCreationRequest.getPassword(), userCreationRequest.getIsOwner());
        return ResponseEntity.ok(new CreateUser201Response());
    }

    private com.uade.screenspace.entity.User getJWTUser(){
        return ((com.uade.screenspace.entity.User) SecurityContextHolder.getContext().getAuthentication().getPrincipal());
    }

    private String getUsedTokenInHeader(){
        return (String) SecurityContextHolder.getContext().getAuthentication().getCredentials();
    }
}
