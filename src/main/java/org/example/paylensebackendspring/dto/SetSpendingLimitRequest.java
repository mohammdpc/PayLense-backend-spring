package org.example.paylensebackendspring.dto;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

import org.example.paylensebackendspring.enums.PeriodType;

import java.math.BigDecimal;
import java.util.UUID;

public record SetSpendingLimitRequest(

        UUID accountId,

        @NotNull(message = "Amount is required")
        @DecimalMin(value = "0.01", message = "Amount must be at least 0.01")
        @Digits(integer = 16, fraction = 2, message = "Amount allows up to 2 decimal places")
        BigDecimal limitAmount,

        @NotBlank(message = "Currency is required")
        @Pattern(regexp = "^[A-Z]{3}$", message = "Currency must be a 3-letter code such as EGP")
        String currency,

        @NotNull(message = "Period type is required")
        PeriodType periodType
) {}
