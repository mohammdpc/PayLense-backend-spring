package org.example.paylensebackendspring.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public record GenerateReportRequest(

        @NotBlank(message = "Report type is required")
        @Size(max = 30, message = "Report type must not exceed 30 characters")
        String reportType,

        @NotNull(message = "Period start is required")
        LocalDate periodStart,

        @NotNull(message = "Period end is required")
        LocalDate periodEnd,

        @NotBlank(message = "Currency is required")
        @Pattern(regexp = "^[A-Z]{3}$", message = "Currency must be a 3-letter code such as EGP")
        String currency
) {}
