package org.example.paylensebackendspring.dto;

import org.example.paylensebackendspring.entity.BillSettlement;

import java.time.Instant;
import java.util.UUID;

public record BillSettlementResponse(
        UUID id,
        UUID billId,
        UUID approvedBy,
        String status,
        Instant approvedAt,
        Instant completedAt,
        Instant createdAt
) {
    public static BillSettlementResponse from(BillSettlement e) {
        return new BillSettlementResponse(
                e.getId(),
                e.getBill().getId(),
                e.getApprovedBy().getId(),
                e.getStatus(),
                e.getApprovedAt(),
                e.getCompletedAt(),
                e.getCreatedAt()
        );
    }
}
