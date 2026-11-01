package org.example.paylensebackendspring.dto;

import org.example.paylensebackendspring.entity.ChatMessage;
import org.example.paylensebackendspring.enums.SenderType;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.UUID;

public record ChatMessageResponse(
        Long id,
        UUID chatSessionId,
        SenderType senderType,
        String content,
        String language,
        BigDecimal confidenceScore,
        boolean fallback,
        Boolean helpful,
        Instant createdAt
) {
    public static ChatMessageResponse from(ChatMessage e) {
        return new ChatMessageResponse(
                e.getId(),
                e.getChatSession().getId(),
                e.getSenderType(),
                e.getContent(),
                e.getLanguage(),
                e.getConfidenceScore(),
                e.isFallback(),
                e.getHelpful(),
                e.getCreatedAt()
        );
    }
}
