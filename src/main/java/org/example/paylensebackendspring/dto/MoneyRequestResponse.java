package org.example.paylensebackendspring.dto;

import org.example.paylensebackendspring.entity.MoneyRequest;
import org.example.paylensebackendspring.enums.MoneyRequestStatus;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.UUID;

public record MoneyRequestResponse(
        UUID id,
        UUID requesterId,
        UUID payerId,
        BigDecimal amount,
        String currency,
        String note,
        MoneyRequestStatus status,
        UUID transactionId,
        Instant createdAt,
        Instant expiresAt,
        Instant respondedAt
) {
    public static MoneyRequestResponse from(MoneyRequest e) {
        return new MoneyRequestResponse(
                e.getId(),
                e.getRequester().getId(),
                e.getPayer().getId(),
                e.getAmount(),
                e.getCurrency(),
                e.getNote(),
                e.getStatus(),
                e.getTransaction() == null ? null : e.getTransaction().getId(),
                e.getCreatedAt(),
                e.getExpiresAt(),
                e.getRespondedAt()
        );
    }
}
