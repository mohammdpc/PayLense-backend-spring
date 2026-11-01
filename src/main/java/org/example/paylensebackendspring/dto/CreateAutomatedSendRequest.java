package org.example.paylensebackendspring.dto;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

import org.example.paylensebackendspring.enums.Frequency;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

public record CreateAutomatedSendRequest(

        UUID receiverId,

        UUID cardId,

        UUID receiverCardId,

        String externalCardToken,

        @Pattern(regexp = "^\\d{4}$", message = "Last 4 must be exactly 4 digits")
        String externalCardLast4,

        Integer categoryId,

        @NotNull(message = "Amount is required")
        @DecimalMin(value = "0.01", message = "Amount must be at least 0.01")
        @Digits(integer = 16, fraction = 2, message = "Amount allows up to 2 decimal places")
        BigDecimal amount,

        @NotBlank(message = "Currency is required")
        @Pattern(regexp = "^[A-Z]{3}$", message = "Currency must be a 3-letter code such as EGP")
        String currency,

        @NotNull(message = "Frequency is required")
        Frequency frequency,

        @Min(value = 1, message = "Interval must be at least 1")
        Integer intervalCount,

        @Min(value = 1, message = "Day of month must be between 1 and 31")
        @Max(value = 31, message = "Day of month must be between 1 and 31")
        Short dayOfMonth,

        @NotNull(message = "Start date is required")
        LocalDate startDate,

        LocalDate endDate
) {}
