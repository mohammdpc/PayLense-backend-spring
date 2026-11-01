package org.example.paylensebackendspring.dto;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

import org.example.paylensebackendspring.entity.Bill;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.UUID;

public record CreateBillRequest(

        @NotBlank(message = "Bill name is required")
        @Size(max = 150, message = "Bill name must not exceed 150 characters")
        String billName,

        @NotNull(message = "Amount is required")
        @DecimalMin(value = "0.01", message = "Amount must be at least 0.01")
        @Digits(integer = 16, fraction = 2, message = "Amount allows up to 2 decimal places")
        BigDecimal targetAmount,

        @NotBlank(message = "Currency is required")
        @Pattern(regexp = "^[A-Z]{3}$", message = "Currency must be a 3-letter code such as EGP")
        String currency,

        Integer categoryId,

        UUID receiverId,

        Instant expiresAt
) {}
