package org.example.paylensebackendspring.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

import java.util.UUID;

public record AddCardRequest(

        @NotNull(message = "Account is required")
        UUID accountId,

        @NotBlank(message = "Card token is required")
        String cardToken,

        @NotBlank(message = "Last 4 digits are required")
        @Pattern(regexp = "^\\d{4}$", message = "Last 4 must be exactly 4 digits")
        String last4,

        @Size(max = 100, message = "Cardholder name must not exceed 100 characters")
        String cardholderName,

        @Min(value = 1, message = "Month must be between 1 and 12")
        @Max(value = 12, message = "Month must be between 1 and 12")
        Short expirationMonth,

        @Min(value = 2000, message = "Invalid expiration year")
        Short expirationYear,

        @NotBlank(message = "Currency is required")
        @Pattern(regexp = "^[A-Z]{3}$", message = "Currency must be a 3-letter code such as EGP")
        String currency
) {}
