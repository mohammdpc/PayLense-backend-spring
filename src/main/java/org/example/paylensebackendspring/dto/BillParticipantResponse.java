package org.example.paylensebackendspring.dto;

import org.example.paylensebackendspring.entity.BillParticipant;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.UUID;

public record BillParticipantResponse(
        UUID billId,
        UUID userId,
        UUID cardId,
        BigDecimal amount,
        String status,
        Instant joinedAt,
        UUID transactionId
) {
    public static BillParticipantResponse from(BillParticipant e) {
        return new BillParticipantResponse(
                e.getId().getBillId(),
                e.getId().getUserId(),
                e.getCard() == null ? null : e.getCard().getId(),
                e.getAmount(),
                e.getStatus(),
                e.getJoinedAt(),
                e.getTransaction() == null ? null : e.getTransaction().getId()
        );
    }
}
