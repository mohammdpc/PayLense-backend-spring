package org.example.paylensebackendspring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.example.paylensebackendspring.entity.PhoneChangeRequest;
import org.example.paylensebackendspring.enums.ChangeRequestStatus;

import java.util.List;
import java.util.UUID;

public interface PhoneChangeRequestRepository extends JpaRepository<PhoneChangeRequest, Long> {

    List<PhoneChangeRequest> findByUserIdAndStatus(UUID userId, ChangeRequestStatus status);
}
