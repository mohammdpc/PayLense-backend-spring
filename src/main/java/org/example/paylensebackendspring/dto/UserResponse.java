package org.example.paylensebackendspring.dto;

import org.example.paylensebackendspring.entity.User;

import java.time.Instant;

public record UserResponse(
        Long id,
        String fullName,
        String phoneNumber,
        String email,
        Instant createdAt
) {
    public static UserResponse from(User user) {
        return new UserResponse(
                user.getId(),
                user.getFullName(),
                user.getPhoneNumber(),
                user.getEmail(),
                user.getCreatedAt()
        );
    }
}