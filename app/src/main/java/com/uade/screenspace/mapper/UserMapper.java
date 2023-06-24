package com.uade.screenspace.mapper;

import io.screenspace.model.User;

public class UserMapper {

    public static User entityToModel(com.uade.screenspace.entity.User userEntity){
        return new User()
                .email(userEntity.getEmail())
                .isOwner(userEntity.getOwner())
                .profilePictureURL(userEntity.getProfilePicBase64())
                .name(userEntity.getUsername());
    }
}
