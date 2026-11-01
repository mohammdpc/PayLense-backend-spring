package org.example.paylensebackendspring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.example.paylensebackendspring.entity.AutomatedSend;

import java.time.Instant;
import java.util.List;
import java.util.UUID;

public interface AutomatedSendRepository extends JpaRepository<AutomatedSend, UUID> {

    List<AutomatedSend> findByUserId(UUID userId);

    List<AutomatedSend> findByActiveTrueAndNextRunAtBefore(Instant now);
}
