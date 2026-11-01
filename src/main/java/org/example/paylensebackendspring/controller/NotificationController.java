package org.example.paylensebackendspring.controller;

import lombok.RequiredArgsConstructor;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import org.example.paylensebackendspring.dto.NotificationResponse;
import org.example.paylensebackendspring.dto.PageResponse;
import org.example.paylensebackendspring.dto.UnreadCountResponse;
import org.example.paylensebackendspring.security.CurrentUser;
import org.example.paylensebackendspring.service.NotificationService;

@RestController
@RequestMapping("/api/notifications")
@RequiredArgsConstructor
public class NotificationController {

    private final NotificationService notificationService;

    @GetMapping
    public PageResponse<NotificationResponse> list(@AuthenticationPrincipal Jwt jwt,
                                                   @RequestParam(defaultValue = "0") int page,
                                                   @RequestParam(defaultValue = "20") int size) {
        return notificationService.list(CurrentUser.id(jwt), page, size);
    }

    @GetMapping("/unread-count")
    public UnreadCountResponse unreadCount(@AuthenticationPrincipal Jwt jwt) {
        return notificationService.unreadCount(CurrentUser.id(jwt));
    }

    @PatchMapping("/{id}/read")
    public NotificationResponse markAsRead(@AuthenticationPrincipal Jwt jwt, @PathVariable Long id) {
        return notificationService.markAsRead(CurrentUser.id(jwt), id);
    }
}
