package com.uade.screenspace.service;

import com.uade.screenspace.entity.PendingUser;
import com.uade.screenspace.entity.User;

public interface IUserService {
    PendingUser createPendingUser(String email, String password, boolean isOwner);

    User confirmUserCreation(String email, String code);

    User findUser(String email, String password, boolean isOwner);

    void deleteUser(String email, boolean isOwner);

    User updateUser(String email, String password, boolean isOwner, String profilePic);

    void passwordReset(String email, boolean isOwner);

    boolean confirmPasswordReset(String email, boolean isOwner, String code);
}
