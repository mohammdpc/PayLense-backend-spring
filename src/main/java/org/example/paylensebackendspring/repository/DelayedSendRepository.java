package org.example.paylensebackendspring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.example.paylensebackendspring.entity.DelayedSend;

import java.time.Instant;
import java.util.List;
import java.util.UUID;

public interface DelayedSendRepository extends JpaRepository<DelayedSend, UUID> {

    List<DelayedSend> findByScheduledAtBeforeAndCancelledAtIsNull(Instant now);
}
