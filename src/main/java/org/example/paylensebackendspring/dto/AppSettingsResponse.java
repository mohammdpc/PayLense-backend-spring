package org.example.paylensebackendspring.dto;

import org.example.paylensebackendspring.entity.AppSettings;

public record AppSettingsResponse(
        String language,
        String theme,
        boolean notificationsEnabled
) {
    public static AppSettingsResponse from(AppSettings e) {
        return new AppSettingsResponse(
                e.getLanguage(),
                e.getTheme(),
                e.isNotificationsEnabled()
        );
    }
}
