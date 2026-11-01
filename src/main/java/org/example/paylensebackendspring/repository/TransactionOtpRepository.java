package org.example.paylensebackendspring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.example.paylensebackendspring.entity.TransactionOtp;

import java.util.Optional;
import java.util.UUID;

public interface TransactionOtpRepository extends JpaRepository<TransactionOtp, Long> {

    Optional<TransactionOtp> findFirstByTransactionIdAndUsedFalseOrderByCreatedAtDesc(UUID transactionId);
}
