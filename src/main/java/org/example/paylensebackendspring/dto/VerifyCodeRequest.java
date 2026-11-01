package org.example.paylensebackendspring.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record VerifyCodeRequest(

        @NotBlank(message = "Code is required")
        @Pattern(regexp = "^\\d{4,8}$", message = "Code must be 4 to 8 digits")
        String code
) {}
