package org.example.paylensebackendspring.dto;

import org.example.paylensebackendspring.entity.Notification;

import java.time.Instant;
import java.util.UUID;

public record NotificationResponse(
        Long id,
        String title,
        String message,
        String notificationType,
        UUID relatedTransactionId,
        boolean read,
        Instant createdAt,
        Instant readAt
) {
    public static NotificationResponse from(Notification e) {
        return new NotificationResponse(
                e.getId(),
                e.getTitle(),
                e.getMessage(),
                e.getNotificationType(),
                e.getRelatedTransaction() == null ? null : e.getRelatedTransaction().getId(),
                e.isRead(),
                e.getCreatedAt(),
                e.getReadAt()
        );
    }
}
