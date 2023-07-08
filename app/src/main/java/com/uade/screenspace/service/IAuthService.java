package com.uade.screenspace.service;

import com.uade.screenspace.entity.RefreshToken;
import com.uade.screenspace.entity.User;

public interface IAuthService {

    RefreshToken getToken(User user, boolean isOwner);

    RefreshToken createRefreshToken(User user);

    void deleteSession(User user, String token);
}
