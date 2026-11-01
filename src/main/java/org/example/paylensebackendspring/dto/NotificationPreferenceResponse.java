package org.example.paylensebackendspring.dto;

import org.example.paylensebackendspring.entity.NotificationPreference;

public record NotificationPreferenceResponse(
        boolean transactionNotifications,
        boolean securityNotifications,
        boolean marketingNotifications,
        boolean emailNotifications,
        boolean pushNotifications
) {
    public static NotificationPreferenceResponse from(NotificationPreference e) {
        return new NotificationPreferenceResponse(
                e.isTransactionNotifications(),
                e.isSecurityNotifications(),
                e.isMarketingNotifications(),
                e.isEmailNotifications(),
                e.isPushNotifications()
        );
    }
}
