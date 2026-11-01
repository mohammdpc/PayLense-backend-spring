package org.example.paylensebackendspring.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import org.example.paylensebackendspring.entity.AutomatedSendRun;

import java.time.Instant;
import java.util.UUID;

public interface AutomatedSendRunRepository extends JpaRepository<AutomatedSendRun, Long> {

    Page<AutomatedSendRun> findByAutomatedSendId(UUID automatedSendId, Pageable pageable);

    boolean existsByAutomatedSendIdAndScheduledFor(UUID automatedSendId, Instant scheduledFor);
}
