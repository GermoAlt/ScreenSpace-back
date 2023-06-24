package com.uade.screenspace.auth;

import com.uade.screenspace.entity.User;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class LoggedUserGetter {

    public  User get(){
        return ((User) SecurityContextHolder.getContext().getAuthentication().getPrincipal());
    }
}
