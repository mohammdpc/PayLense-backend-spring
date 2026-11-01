package org.example.paylensebackendspring.dto;

import org.example.paylensebackendspring.entity.Transaction;
import org.example.paylensebackendspring.enums.SendType;
import org.example.paylensebackendspring.enums.TransactionSource;
import org.example.paylensebackendspring.enums.TransactionStatus;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.UUID;

public record TransactionResponse(
        UUID id,
        UUID senderId,
        UUID receiverId,
        BigDecimal amount,
        String currency,
        SendType sendType,
        TransactionSource source,
        TransactionStatus status,
        boolean exceedsLimit,
        boolean requiresTwoFa,
        String failureReason,
        Instant createdAt,
        Instant completedAt
) {
    public static TransactionResponse from(Transaction e) {
        return new TransactionResponse(
                e.getId(),
                e.getSender().getId(),
                e.getReceiver() == null ? null : e.getReceiver().getId(),
                e.getAmount(),
                e.getCurrency(),
                e.getSendType(),
                e.getSource(),
                e.getStatus(),
                e.isExceedsLimit(),
                e.isRequiresTwoFa(),
                e.getFailureReason(),
                e.getCreatedAt(),
                e.getCompletedAt()
        );
    }
}
