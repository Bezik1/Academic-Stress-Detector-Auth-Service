package com.authservice.authservice.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.authservice.authservice.service.AuthService;
import com.authservice.authservice.service.JWTService;
import com.authservice.authservice.dto.LoginRequest;
import com.authservice.authservice.dto.ValidationResponse;
import com.authservice.authservice.model.User;

import io.jsonwebtoken.Claims;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

@RestController
@RequestMapping("/auth")
public class AuthController {
    private final AuthService authService;
    private final JWTService jwtService;

    public AuthController(AuthService authService, JWTService jwtService) {
        this.authService = authService;
        this.jwtService = jwtService;
    }


@GetMapping("/validate")
public ValidationResponse validateToken(@RequestHeader("Authorization") String authHeader) {
    if (authHeader == null || !authHeader.startsWith("Bearer ")) {
        throw new RuntimeException("Missing or invalid Authorization header");
    }
    String token = authHeader.substring(7);

    boolean valid = jwtService.validateToken(token);
    if (!valid) {
        throw new RuntimeException("Invalid or expired token");
    }

    Claims claims = jwtService.getClaims(token);

    Object rolesObj = claims.get("roles");
    Set<String> rolesSet;
    if (rolesObj instanceof List<?> rolesList) {
        rolesSet = rolesList.stream()
                .map(Object::toString)
                .collect(Collectors.toSet());
    } else {
        rolesSet = Set.of();
    }

    return new ValidationResponse(
            claims.getSubject(),
            claims.get("username", String.class),
            rolesSet
    );
}

    @PostMapping("/register")
    public User registerUser(@RequestBody User user) {
        return authService.registerUser(user.getUsername(), user.getEmail(), user.getPassword());
    }
    
    @PostMapping("/login")
    public String login(@RequestBody LoginRequest loginRequest) {
        return authService.login(loginRequest.getEmail(), loginRequest.getPassword());
    }
}
