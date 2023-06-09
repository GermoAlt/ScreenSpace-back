package com.uade.screenspace.service;

import com.uade.screenspace.entity.PendingUser;
import com.uade.screenspace.entity.User;

import java.util.Optional;

public interface IUserService {
    PendingUser createPendingUser(String email, String password, boolean isOwner);

    User confirmUserCreation(String email, String code);

    User findUserById(String id);

    User findUser(String email, String password, boolean isOwner);

    void deleteUser(User user);

    User updateUser(String email, boolean isOwner, String profilePic, String name);

    void passwordReset(String email);

    void confirmPasswordReset(String email, String code);

    void updatePassword(String email, String password, String code);

    User findOrCreateOauthUser(String email);
}
