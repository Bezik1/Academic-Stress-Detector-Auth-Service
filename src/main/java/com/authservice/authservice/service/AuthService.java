package com.authservice.authservice.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.authservice.authservice.model.Role;
import com.authservice.authservice.model.User;
import com.authservice.authservice.repository.RoleRepository;
import com.authservice.authservice.repository.UserRepository;

@Service
public class AuthService {
    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final JWTService jwtService;

    public AuthService(JWTService jwtService, PasswordEncoder passwordEncoder, UserRepository userRepository, RoleRepository roleRepository) {
        this.jwtService = jwtService;
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    public User registerUser(String username, String email, String password) {
        String hashedPassword = passwordEncoder.encode(password);

        User user = new User();
        user.setUsername(username);
        user.setEmail(email);
        user.setPassword(hashedPassword);

        user = userRepository.save(user);

        Role role = new Role();
        role.setRole("USER");
        role.setUserId(user.getId());

        roleRepository.save(role);
        return user;
    }

    public String login(String email, String password) {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Cannot find user with email:  " + email));

        if(!passwordEncoder.matches(password, user.getPassword()))
            throw new RuntimeException("Incorrect Password!");

        String token = jwtService.generateToken(
            user.getId(),
            user.getUsername(),
            user.getRoles()
        );

        return token;
    }
}
