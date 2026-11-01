package org.example.paylensebackendspring.dto;

import org.example.paylensebackendspring.entity.FinancialAccount;

import java.time.Instant;
import java.util.UUID;

public record AccountResponse(
        UUID id,
        String accountName,
        String currency,
        String accountStatus,
        Instant createdAt
) {
    public static AccountResponse from(FinancialAccount e) {
        return new AccountResponse(
                e.getId(),
                e.getAccountName(),
                e.getCurrency(),
                e.getAccountStatus(),
                e.getCreatedAt()
        );
    }
}
