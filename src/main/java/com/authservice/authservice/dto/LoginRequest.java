package com.authservice.authservice.dto;

import jakarta.validation.constraints.*;

public class LoginRequest {
    @NotBlank(message = "Email cannot be empty!")
    @Email(message = "Incorrect Email!")
    private String email;

    @NotBlank(message = "Password cannot be empty!")
    private String password;

    public LoginRequest() {}

    public LoginRequest(
            @NotBlank(message = "Password cannot be empty!") @Email(message = "Incorrect Email!") String email,
            @NotBlank(message = "Password cannot be empty!") String password) {
        this.email = email;
        this.password = password;
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
}
