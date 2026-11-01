package org.example.paylensebackendspring.dto;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

public record UpdateReceiptRequest(

        UUID transactionId,

        @Size(max = 200, message = "Merchant name must not exceed 200 characters")
        String merchantName,

        @DecimalMin(value = "0.00", message = "Amount must not be negative")
        @Digits(integer = 16, fraction = 2, message = "Amount allows up to 2 decimal places")
        BigDecimal amount,

        @Pattern(regexp = "^[A-Z]{3}$", message = "Currency must be a 3-letter code such as EGP")
        String currency,

        LocalDate receiptDate,

        Integer categoryId,

        Boolean includeInReport
) {}
