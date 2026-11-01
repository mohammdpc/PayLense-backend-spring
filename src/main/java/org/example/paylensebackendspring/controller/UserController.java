package org.example.paylensebackendspring.controller;

import jakarta.validation.Valid;

import lombok.RequiredArgsConstructor;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.example.paylensebackendspring.dto.AppSettingsResponse;
import org.example.paylensebackendspring.dto.ContactMethodResponse;
import org.example.paylensebackendspring.dto.NotificationPreferenceResponse;
import org.example.paylensebackendspring.dto.UpdateAppSettingsRequest;
import org.example.paylensebackendspring.dto.UpdateNotificationPreferenceRequest;
import org.example.paylensebackendspring.dto.UserResponse;
import org.example.paylensebackendspring.security.CurrentUser;
import org.example.paylensebackendspring.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/api/users/me")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping
    public UserResponse me(@AuthenticationPrincipal Jwt jwt) {
        return userService.getMe(CurrentUser.id(jwt));
    }

    @GetMapping("/contacts")
    public List<ContactMethodResponse> contacts(@AuthenticationPrincipal Jwt jwt) {
        return userService.getContacts(CurrentUser.id(jwt));
    }

    @GetMapping("/settings")
    public AppSettingsResponse settings(@AuthenticationPrincipal Jwt jwt) {
        return userService.getSettings(CurrentUser.id(jwt));
    }

    @PutMapping("/settings")
    public AppSettingsResponse updateSettings(@AuthenticationPrincipal Jwt jwt,
                                              @Valid @RequestBody UpdateAppSettingsRequest request) {
        return userService.updateSettings(CurrentUser.id(jwt), request);
    }

    @GetMapping("/notification-preferences")
    public NotificationPreferenceResponse notificationPreferences(@AuthenticationPrincipal Jwt jwt) {
        return userService.getNotificationPreferences(CurrentUser.id(jwt));
    }

    @PutMapping("/notification-preferences")
    public NotificationPreferenceResponse updateNotificationPreferences(
            @AuthenticationPrincipal Jwt jwt,
            @Valid @RequestBody UpdateNotificationPreferenceRequest request) {
        return userService.updateNotificationPreferences(CurrentUser.id(jwt), request);
    }
}
