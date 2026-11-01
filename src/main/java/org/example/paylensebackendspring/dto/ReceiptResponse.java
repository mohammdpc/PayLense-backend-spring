package org.example.paylensebackendspring.dto;

import org.example.paylensebackendspring.entity.Receipt;

import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDate;
import java.util.UUID;

public record ReceiptResponse(
        UUID id,
        UUID transactionId,
        String imagePath,
        String merchantName,
        BigDecimal amount,
        String currency,
        LocalDate receiptDate,
        Integer categoryId,
        Integer suggestedCategoryId,
        BigDecimal aiConfidence,
        boolean includeInReport,
        Instant createdAt
) {
    public static ReceiptResponse from(Receipt e) {
        return new ReceiptResponse(
                e.getId(),
                e.getTransaction() == null ? null : e.getTransaction().getId(),
                e.getImagePath(),
                e.getMerchantName(),
                e.getAmount(),
                e.getCurrency(),
                e.getReceiptDate(),
                e.getCategory() == null ? null : e.getCategory().getId(),
                e.getSuggestedCategory() == null ? null : e.getSuggestedCategory().getId(),
                e.getAiConfidence(),
                e.isIncludeInReport(),
                e.getCreatedAt()
        );
    }
}
