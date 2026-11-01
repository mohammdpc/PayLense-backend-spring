package org.example.paylensebackendspring.dto;

import jakarta.validation.constraints.Size;

public record UpdateAppSettingsRequest(

        @Size(max = 10, message = "Language must not exceed 10 characters")
        String language,

        @Size(max = 10, message = "Theme must not exceed 10 characters")
        String theme,

        Boolean notificationsEnabled
) {}
