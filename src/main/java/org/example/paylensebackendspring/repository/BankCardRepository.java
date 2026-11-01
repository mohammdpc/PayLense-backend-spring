package org.example.paylensebackendspring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.example.paylensebackendspring.entity.BankCard;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface BankCardRepository extends JpaRepository<BankCard, UUID> {

    List<BankCard> findByUserId(UUID userId);

    List<BankCard> findByAccountId(UUID accountId);

    Optional<BankCard> findByIdAndUserId(UUID id, UUID userId);

    long countByUserId(UUID userId);

    boolean existsByUserIdAndCardFingerprint(UUID userId, String cardFingerprint);
}
