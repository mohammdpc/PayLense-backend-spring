package org.example.paylensebackendspring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.example.paylensebackendspring.entity.EmailChangeRequest;
import org.example.paylensebackendspring.enums.ChangeRequestStatus;

import java.util.List;
import java.util.UUID;

public interface EmailChangeRequestRepository extends JpaRepository<EmailChangeRequest, Long> {

    List<EmailChangeRequest> findByUserIdAndStatus(UUID userId, ChangeRequestStatus status);
}
