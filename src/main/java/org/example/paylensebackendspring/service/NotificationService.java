package org.example.paylensebackendspring.service;

import lombok.RequiredArgsConstructor;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import org.example.paylensebackendspring.dto.NotificationResponse;
import org.example.paylensebackendspring.dto.PageResponse;
import org.example.paylensebackendspring.dto.UnreadCountResponse;
import org.example.paylensebackendspring.entity.Notification;
import org.example.paylensebackendspring.exception.ResourceNotFoundException;
import org.example.paylensebackendspring.repository.NotificationRepository;
import org.example.paylensebackendspring.util.Paging;

import java.time.Instant;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class NotificationService {

    private final NotificationRepository notificationRepository;

    @Transactional(readOnly = true)
    public PageResponse<NotificationResponse> list(UUID userId, int page, int size) {
        Page<NotificationResponse> result = notificationRepository
                .findByUserIdOrderByCreatedAtDesc(userId, Paging.of(page, size))
                .map(NotificationResponse::from);
        return PageResponse.from(result);
    }

    @Transactional(readOnly = true)
    public UnreadCountResponse unreadCount(UUID userId) {
        return new UnreadCountResponse(notificationRepository.countByUserIdAndReadFalse(userId));
    }

    @Transactional
    public NotificationResponse markAsRead(UUID userId, Long notificationId) {
        Notification notification = notificationRepository.findByIdAndUserId(notificationId, userId)
                .orElseThrow(() -> new ResourceNotFoundException("Notification not found"));
        if (!notification.isRead()) {
            notification.setRead(true);
            notification.setReadAt(Instant.now());
        }
        return NotificationResponse.from(notification);
    }
}
