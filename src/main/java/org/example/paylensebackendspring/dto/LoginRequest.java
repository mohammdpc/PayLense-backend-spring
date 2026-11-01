
package org.example.paylensebackendspring.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record LoginRequest(

        @NotBlank(message = "Username, email or phone is required")
        String identifier,

        @NotBlank(message = "Password is required")
        @Size(min = 8, max = 64, message = "Invalid password length")
        String password
) {}
