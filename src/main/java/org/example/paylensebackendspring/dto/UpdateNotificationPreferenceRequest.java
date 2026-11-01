package org.example.paylensebackendspring.dto;

public record UpdateNotificationPreferenceRequest(
        Boolean transactionNotifications,
        Boolean securityNotifications,
        Boolean marketingNotifications,
        Boolean emailNotifications,
        Boolean pushNotifications
) {}
