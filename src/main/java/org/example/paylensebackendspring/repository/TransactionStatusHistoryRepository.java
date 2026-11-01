package org.example.paylensebackendspring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.example.paylensebackendspring.entity.TransactionStatusHistory;

import java.util.List;
import java.util.UUID;

public interface TransactionStatusHistoryRepository extends JpaRepository<TransactionStatusHistory, Long> {

    List<TransactionStatusHistory> findByTransactionIdOrderByChangedAtAsc(UUID transactionId);
}
