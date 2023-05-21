package com.uade.screenspace.service;

import com.uade.screenspace.entity.User;
import com.uade.screenspace.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;


    public User createUser(String email, String password, boolean isOwner){
        return repository.save(new User(email, password, isOwner));
    }

}
