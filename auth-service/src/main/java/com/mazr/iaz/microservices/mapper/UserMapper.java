package com.mazr.iaz.microservices.mapper;

import org.springframework.stereotype.Component;

import com.mazr.iaz.microservices.dto.RegisterRequest;
import com.mazr.iaz.microservices.dto.UserResponse;
import com.mazr.iaz.microservices.entity.User;

@Component
public class UserMapper {

    /**
     * Converts RegisterRequest (DTO) → User (Entity)
     */
    public User toEntity(RegisterRequest request, String encryptedPassword) {
        return User.builder()
            .username(request.getUsername())
            .email(request.getEmail())
            .firstName(request.getFirstName())
            .lastName(request.getLastName())
            .avatar(request.getAvatar())
            .passwordHash(encryptedPassword)
            .accountLocked(false)
            .failedLoginAttempts(0)
            .build();
    }


    /**
     * Converts User(Entity) → RegisterRequest (DTO)
     */

    public UserResponse toResponse(User user) {
        return UserResponse.builder()
            .id(user.getId())
            .username(user.getUsername())
            .email(user.getEmail())
            .firstName(user.getFirstName())
            .lastName(user.getLastName())
            .avatar(user.getAvatar())
            .createdAt(user.getCreatedAt())
            .build();
    }

}


