package com.authservice.authservice.service;

import org.springframework.stereotype.Service;

import com.authservice.authservice.repository.UserRepository;

@Service
public class LoginService {
    private final UserRepository userRepository;

    public LoginService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void login() {
        
    }
}
