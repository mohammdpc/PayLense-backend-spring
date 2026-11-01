package org.example.paylensebackendspring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.example.paylensebackendspring.entity.UserContactMethod;
import org.example.paylensebackendspring.enums.ContactType;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface UserContactMethodRepository extends JpaRepository<UserContactMethod, Long> {

    Optional<UserContactMethod> findByContactTypeAndContactValue(ContactType contactType, String contactValue);

    boolean existsByContactTypeAndContactValue(ContactType contactType, String contactValue);

    List<UserContactMethod> findByUserId(UUID userId);

    List<UserContactMethod> findByUserIdAndContactType(UUID userId, ContactType contactType);
}
