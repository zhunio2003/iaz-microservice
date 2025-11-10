package com.mazr.iaz.microservices.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LoginRequest {

    @NotBlank(message = "email o username is required")
    private String usernameOrEmail;

    @NotBlank(message = "password is required")
    private String passwordHash;
}
