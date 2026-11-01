package org.example.paylensebackendspring.dto;

import org.example.paylensebackendspring.entity.LedgerEntry;
import org.example.paylensebackendspring.enums.EntryType;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.UUID;

public record LedgerEntryResponse(
        Long id,
        UUID transactionId,
        UUID accountId,
        EntryType entryType,
        BigDecimal amount,
        String currency,
        Instant createdAt
) {
    public static LedgerEntryResponse from(LedgerEntry e) {
        return new LedgerEntryResponse(
                e.getId(),
                e.getTransaction().getId(),
                e.getAccount().getId(),
                e.getEntryType(),
                e.getAmount(),
                e.getCurrency(),
                e.getCreatedAt()
        );
    }
}
