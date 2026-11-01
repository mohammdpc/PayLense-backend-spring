package org.example.paylensebackendspring.dto;

import jakarta.validation.constraints.NotNull;

public record ChatFeedbackRequest(

        @NotNull(message = "Feedback is required")
        Boolean helpful
) {}
