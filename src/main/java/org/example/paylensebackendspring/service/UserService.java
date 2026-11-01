package org.example.paylensebackendspring.service;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import org.example.paylensebackendspring.dto.AppSettingsResponse;
import org.example.paylensebackendspring.dto.ContactMethodResponse;
import org.example.paylensebackendspring.dto.NotificationPreferenceResponse;
import org.example.paylensebackendspring.dto.UpdateAppSettingsRequest;
import org.example.paylensebackendspring.dto.UpdateNotificationPreferenceRequest;
import org.example.paylensebackendspring.dto.UserResponse;
import org.example.paylensebackendspring.entity.AppSettings;
import org.example.paylensebackendspring.entity.Notification;
import org.example.paylensebackendspring.entity.NotificationPreference;
import org.example.paylensebackendspring.entity.User;
import org.example.paylensebackendspring.exception.ResourceNotFoundException;
import org.example.paylensebackendspring.repository.AppSettingsRepository;
import org.example.paylensebackendspring.repository.NotificationPreferenceRepository;
import org.example.paylensebackendspring.repository.UserContactMethodRepository;
import org.example.paylensebackendspring.repository.UserRepository;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final UserContactMethodRepository contactRepository;
    private final AppSettingsRepository appSettingsRepository;
    private final NotificationPreferenceRepository notificationPreferenceRepository;

    @Transactional(readOnly = true)
    public UserResponse getMe(UUID userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));
        return UserResponse.from(user);
    }

    @Transactional(readOnly = true)
    public List<ContactMethodResponse> getContacts(UUID userId) {
        return contactRepository.findByUserId(userId).stream()
                .map(ContactMethodResponse::from)
                .toList();
    }

    @Transactional(readOnly = true)
    public AppSettingsResponse getSettings(UUID userId) {
        return AppSettingsResponse.from(findSettings(userId));
    }

    @Transactional
    public AppSettingsResponse updateSettings(UUID userId, UpdateAppSettingsRequest request) {
        AppSettings settings = findSettings(userId);
        if (request.language() != null) {
            settings.setLanguage(request.language());
        }
        if (request.theme() != null) {
            settings.setTheme(request.theme());
        }
        if (request.notificationsEnabled() != null) {
            settings.setNotificationsEnabled(request.notificationsEnabled());
        }
        return AppSettingsResponse.from(settings);
    }

    @Transactional(readOnly = true)
    public NotificationPreferenceResponse getNotificationPreferences(UUID userId) {
        return NotificationPreferenceResponse.from(findPreferences(userId));
    }

    @Transactional
    public NotificationPreferenceResponse updateNotificationPreferences(
            UUID userId, UpdateNotificationPreferenceRequest request) {
        NotificationPreference prefs = findPreferences(userId);
        if (request.transactionNotifications() != null) {
            prefs.setTransactionNotifications(request.transactionNotifications());
        }
        if (request.securityNotifications() != null) {
            prefs.setSecurityNotifications(request.securityNotifications());
        }
        if (request.marketingNotifications() != null) {
            prefs.setMarketingNotifications(request.marketingNotifications());
        }
        if (request.emailNotifications() != null) {
            prefs.setEmailNotifications(request.emailNotifications());
        }
        if (request.pushNotifications() != null) {
            prefs.setPushNotifications(request.pushNotifications());
        }
        return NotificationPreferenceResponse.from(prefs);
    }

    private AppSettings findSettings(UUID userId) {
        return appSettingsRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("Settings not found"));
    }

    private NotificationPreference findPreferences(UUID userId) {
        return notificationPreferenceRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("Notification preferences not found"));
    }
}
