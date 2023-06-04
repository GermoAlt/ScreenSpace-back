package com.uade.screenspace.service;

import com.uade.screenspace.auth.JwtTokenUtil;
import com.uade.screenspace.entity.RefreshToken;
import com.uade.screenspace.entity.User;
import com.uade.screenspace.repository.RefreshTokenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class AuthService implements IAuthService {

    @Autowired
    JwtTokenUtil jwtTokenUtil;
    @Autowired
    RefreshTokenRepository refreshTokenRepository;

    @Override
    public RefreshToken getToken(User user) {
        String token = jwtTokenUtil.generateAccessToken(user);
        RefreshToken refreshToken = createRefreshToken(user);
        refreshToken.setJwt(token);

        return refreshTokenRepository.save(refreshToken);
    }

    public RefreshToken createRefreshToken(User user) {
        RefreshToken refreshToken = jwtTokenUtil.createRefreshToken(user);

        return refreshTokenRepository.save(refreshToken);
    }

    @Override
    public void deleteSession(User user, String token) {
        var deleted = refreshTokenRepository.deleteByUserAndJwt(user, token);
    }
}
