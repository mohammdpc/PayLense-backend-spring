package org.example.paylensebackendspring.dto;

import org.example.paylensebackendspring.entity.User;

import java.time.Instant;
import java.util.UUID;

public record UserResponse(
        UUID id,
        String username,
        boolean active,
        Instant createdAt
) {
    public static UserResponse from(User e) {
        return new UserResponse(
                e.getId(),
                e.getUsername(),
                e.isActive(),
                e.getCreatedAt()
        );
    }
}
