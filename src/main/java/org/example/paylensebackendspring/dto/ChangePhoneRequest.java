package org.example.paylensebackendspring.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record ChangePhoneRequest(

        @NotBlank(message = "Phone number is required")
        @Pattern(regexp = "^01[0125][0-9]{8}$", message = "Invalid Egyptian phone number")
        String newPhoneNumber
) {}
