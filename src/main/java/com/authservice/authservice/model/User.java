package com.authservice.authservice.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
@Table(name = "\"user\"")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Username cannot be empty!")
    @Column(length = 100, nullable = false, unique = true)
    private String username;

    @NotBlank(message = "Email cannot be empty!")
    @Email(message = "Incorrect Email!")
    @Column(length = 255, nullable = false, unique = true)
    private String email;

    @NotBlank(message = "Password cannot be empty!")
    @Size(min = 6, message = "Password must have at least 6 letters!")
    @Pattern.List({
        @Pattern(regexp = ".*[A-Z].*", message = "Password must contain an uppercase letter!"),
        @Pattern(regexp = ".*[a-z].*", message = "Password must contain at least one lower letter!"),
        @Pattern(regexp = ".*[@$!%*?&].*", message = "Password must contain a special character!")
    })
    @Column(length = 255, nullable = false)
    private String password;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Session> sessions = new ArrayList<>();

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"))
    @Column(name = "role")
    private Set<String> roles = new HashSet<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Session> getSessions() {
        return sessions;
    }

    public void setSessions(List<Session> sessions) {
        this.sessions = sessions;
    }

    public Set<String> getRoles() {
        return roles;
    }

    public void setRoles(Set<String> roles) {
        this.roles = roles;
    }

    public User() {}

    public User(String username, String email, String password, List<Session> sessions, Set<String> roles) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.sessions = sessions;
        this.roles = roles;
    }
}
