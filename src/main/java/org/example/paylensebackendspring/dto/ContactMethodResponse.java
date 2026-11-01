package org.example.paylensebackendspring.dto;

import org.example.paylensebackendspring.entity.UserContactMethod;
import org.example.paylensebackendspring.enums.ContactType;

public record ContactMethodResponse(
        Long id,
        ContactType contactType,
        String contactValue,
        boolean primary,
        boolean verified,
        boolean active
) {
    public static ContactMethodResponse from(UserContactMethod e) {
        return new ContactMethodResponse(
                e.getId(),
                e.getContactType(),
                e.getContactValue(),
                e.isPrimary(),
                e.isVerified(),
                e.isActive()
        );
    }
}
