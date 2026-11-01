package org.example.paylensebackendspring.dto;

import org.example.paylensebackendspring.entity.SpendingLimit;
import org.example.paylensebackendspring.enums.PeriodType;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.UUID;

public record SpendingLimitResponse(
        Long id,
        UUID accountId,
        BigDecimal limitAmount,
        String currency,
        PeriodType periodType,
        boolean active,
        Instant createdAt
) {
    public static SpendingLimitResponse from(SpendingLimit e) {
        return new SpendingLimitResponse(
                e.getId(),
                e.getAccount() == null ? null : e.getAccount().getId(),
                e.getLimitAmount(),
                e.getCurrency(),
                e.getPeriodType(),
                e.isActive(),
                e.getCreatedAt()
        );
    }
}
