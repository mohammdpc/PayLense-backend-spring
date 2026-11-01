package org.example.paylensebackendspring.dto;

import org.example.paylensebackendspring.entity.EmailChangeRequest;
import org.example.paylensebackendspring.entity.PhoneChangeRequest;
import org.example.paylensebackendspring.enums.ChangeRequestStatus;

import java.time.Instant;

public record ChangeRequestResponse(
        Long id,
        ChangeRequestStatus status,
        Instant requestedAt,
        Instant expiresAt,
        Instant completedAt
) {
    public static ChangeRequestResponse from(PhoneChangeRequest e) {
        return new ChangeRequestResponse(
                e.getId(),
                e.getStatus(),
                e.getRequestedAt(),
                e.getExpiresAt(),
                e.getCompletedAt()
        );
    }

    public static ChangeRequestResponse from(EmailChangeRequest e) {
        return new ChangeRequestResponse(
                e.getId(),
                e.getStatus(),
                e.getRequestedAt(),
                e.getExpiresAt(),
                e.getCompletedAt()
        );
    }
}
