package org.example.paylensebackendspring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.example.paylensebackendspring.entity.AuthenticationChallenge;

import java.util.Optional;
import java.util.UUID;

public interface AuthenticationChallengeRepository extends JpaRepository<AuthenticationChallenge, Long> {

    Optional<AuthenticationChallenge> findFirstByUserIdAndChallengeTypeAndUsedFalseOrderByCreatedAtDesc(UUID userId, String challengeType);
}
