package org.example.paylensebackendspring.dto;

import org.example.paylensebackendspring.entity.Bill;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.UUID;

public record BillResponse(
        UUID id,
        UUID creatorId,
        UUID receiverId,
        Integer categoryId,
        String billName,
        BigDecimal targetAmount,
        String currency,
        String status,
        Instant expiresAt,
        Instant createdAt,
        Instant paidAt
) {
    public static BillResponse from(Bill e) {
        return new BillResponse(
                e.getId(),
                e.getCreator().getId(),
                e.getReceiver() == null ? null : e.getReceiver().getId(),
                e.getCategory() == null ? null : e.getCategory().getId(),
                e.getBillName(),
                e.getTargetAmount(),
                e.getCurrency(),
                e.getStatus(),
                e.getExpiresAt(),
                e.getCreatedAt(),
                e.getPaidAt()
        );
    }
}
