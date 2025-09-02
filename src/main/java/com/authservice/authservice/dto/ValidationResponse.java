package com.authservice.authservice.dto;

import java.util.Set;

public class ValidationResponse {
    private String userId;
    private String username;
    private Set<String> roles;

    public ValidationResponse() {}

    public ValidationResponse(String userId, String username, Set<String> roles) {
        this.userId = userId;
        this.username = username;
        this.roles = roles;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Set<String> getRoles() {
        return roles;
    }

    public void setRoles(Set<String> roles) {
        this.roles = roles;
    }

    
}
