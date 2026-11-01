package org.example.paylensebackendspring.dto;

import org.example.paylensebackendspring.entity.AutomatedSend;
import org.example.paylensebackendspring.enums.Frequency;

import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDate;
import java.util.UUID;

public record AutomatedSendResponse(
        UUID id,
        UUID receiverId,
        UUID cardId,
        UUID receiverCardId,
        String externalCardLast4,
        Integer categoryId,
        BigDecimal amount,
        String currency,
        Frequency frequency,
        int intervalCount,
        Short dayOfMonth,
        LocalDate startDate,
        LocalDate endDate,
        Instant nextRunAt,
        Instant lastRunAt,
        boolean active,
        Instant createdAt
) {
    public static AutomatedSendResponse from(AutomatedSend e) {
        return new AutomatedSendResponse(
                e.getId(),
                e.getReceiver() == null ? null : e.getReceiver().getId(),
                e.getCard() == null ? null : e.getCard().getId(),
                e.getReceiverCard() == null ? null : e.getReceiverCard().getId(),
                e.getExternalCardLast4(),
                e.getCategory() == null ? null : e.getCategory().getId(),
                e.getAmount(),
                e.getCurrency(),
                e.getFrequency(),
                e.getIntervalCount(),
                e.getDayOfMonth(),
                e.getStartDate(),
                e.getEndDate(),
                e.getNextRunAt(),
                e.getLastRunAt(),
                e.isActive(),
                e.getCreatedAt()
        );
    }
}
