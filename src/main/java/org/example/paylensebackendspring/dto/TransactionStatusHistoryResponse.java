package org.example.paylensebackendspring.dto;

import org.example.paylensebackendspring.entity.TransactionStatusHistory;
import org.example.paylensebackendspring.enums.TransactionStatus;

import java.time.Instant;

public record TransactionStatusHistoryResponse(
        TransactionStatus oldStatus,
        TransactionStatus newStatus,
        String changeReason,
        Instant changedAt
) {
    public static TransactionStatusHistoryResponse from(TransactionStatusHistory e) {
        return new TransactionStatusHistoryResponse(
                e.getOldStatus(),
                e.getNewStatus(),
                e.getChangeReason(),
                e.getChangedAt()
        );
    }
}
