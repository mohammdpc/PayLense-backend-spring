package org.example.paylensebackendspring.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.UUID;

public record SendChatMessageRequest(

        UUID chatSessionId,

        @NotBlank(message = "Message is required")
        @Size(max = 2000, message = "Message must not exceed 2000 characters")
        String content,

        @Size(max = 10, message = "Language must not exceed 10 characters")
        String language
) {}
