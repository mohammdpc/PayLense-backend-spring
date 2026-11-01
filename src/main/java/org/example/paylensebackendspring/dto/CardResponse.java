package org.example.paylensebackendspring.dto;

import org.example.paylensebackendspring.entity.BankCard;

import java.time.Instant;
import java.util.UUID;

public record CardResponse(
        UUID id,
        UUID accountId,
        String last4,
        String cardholderName,
        Short expirationMonth,
        Short expirationYear,
        String currency,
        String cardStatus,
        boolean defaultCard,
        Instant createdAt
) {
    public static CardResponse from(BankCard e) {
        return new CardResponse(
                e.getId(),
                e.getAccount().getId(),
                e.getLast4(),
                e.getCardholderName(),
                e.getExpirationMonth(),
                e.getExpirationYear(),
                e.getCurrency(),
                e.getCardStatus(),
                e.isDefaultCard(),
                e.getCreatedAt()
        );
    }
}
