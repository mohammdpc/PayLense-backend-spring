package org.example.paylensebackendspring.dto;

import org.example.paylensebackendspring.entity.ChatSession;

import java.time.Instant;
import java.util.UUID;

public record ChatSessionResponse(
        UUID id,
        String sessionStatus,
        Instant startedAt,
        Instant endedAt
) {
    public static ChatSessionResponse from(ChatSession e) {
        return new ChatSessionResponse(
                e.getId(),
                e.getSessionStatus(),
                e.getStartedAt(),
                e.getEndedAt()
        );
    }
}
