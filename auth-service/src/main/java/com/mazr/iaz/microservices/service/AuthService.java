package com.mazr.iaz.microservices.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mazr.iaz.microservices.repository.UserRepository;

@Service
public class AuthService {

    @Autowired
    private UserRepository userRepository;

    public void registerUser(String username, String email, String passwordHash) {
        
    }
}
