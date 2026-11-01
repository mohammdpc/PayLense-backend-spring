package org.example.paylensebackendspring.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record ChangeEmailRequest(

        @NotBlank(message = "Email is required")
        @Email(message = "Invalid email format")
        String newEmail
) {}
