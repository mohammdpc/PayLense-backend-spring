package org.example.paylensebackendspring.dto;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.util.UUID;

public record JoinBillRequest(

        @NotNull(message = "Amount is required")
        @DecimalMin(value = "0.01", message = "Amount must be at least 0.01")
        @Digits(integer = 16, fraction = 2, message = "Amount allows up to 2 decimal places")
        BigDecimal amount,

        UUID cardId
) {}
