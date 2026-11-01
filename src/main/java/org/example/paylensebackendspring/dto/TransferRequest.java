package org.example.paylensebackendspring.dto;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

import org.example.paylensebackendspring.enums.SendType;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.UUID;

public record TransferRequest(

        @NotNull(message = "Idempotency key is required")
        UUID idempotencyKey,

        UUID receiverId,

        UUID senderCardId,

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

        @NotNull(message = "Send type is required")
        SendType sendType,

        Instant scheduledAt,

        @Size(max = 250, message = "Message must not exceed 250 characters")
        String message
) {}
