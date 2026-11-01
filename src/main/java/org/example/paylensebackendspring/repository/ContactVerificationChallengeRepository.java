package org.example.paylensebackendspring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.example.paylensebackendspring.entity.ContactVerificationChallenge;

import java.util.Optional;

public interface ContactVerificationChallengeRepository extends JpaRepository<ContactVerificationChallenge, Long> {

    Optional<ContactVerificationChallenge> findFirstByContactIdAndVerifiedFalseOrderByCreatedAtDesc(Long contactId);
}
