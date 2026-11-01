package org.example.paylensebackendspring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.example.paylensebackendspring.entity.LoginSession;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface LoginSessionRepository extends JpaRepository<LoginSession, UUID> {

    Optional<LoginSession> findBySessionTokenHash(String sessionTokenHash);

    List<LoginSession> findByUserIdAndRevokedAtIsNull(UUID userId);
}
