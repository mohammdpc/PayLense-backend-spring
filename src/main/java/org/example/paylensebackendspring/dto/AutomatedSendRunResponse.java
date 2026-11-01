package org.example.paylensebackendspring.dto;

import org.example.paylensebackendspring.entity.AutomatedSendRun;

import java.time.Instant;
import java.util.UUID;

public record AutomatedSendRunResponse(
        Long id,
        UUID automatedSendId,
        Instant scheduledFor,
        Instant executedAt,
        String status,
        UUID transactionId,
        String failureReason
) {
    public static AutomatedSendRunResponse from(AutomatedSendRun e) {
        return new AutomatedSendRunResponse(
                e.getId(),
                e.getAutomatedSend().getId(),
                e.getScheduledFor(),
                e.getExecutedAt(),
                e.getStatus(),
                e.getTransaction() == null ? null : e.getTransaction().getId(),
                e.getFailureReason()
        );
    }
}
