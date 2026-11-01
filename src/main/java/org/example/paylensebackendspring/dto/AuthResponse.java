package org.example.paylensebackendspring.dto;

public record AuthResponse(
        String accessToken,
        String tokenType,
        long expiresInSeconds
) {}
