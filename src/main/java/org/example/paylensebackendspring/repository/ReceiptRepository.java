package org.example.paylensebackendspring.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import org.example.paylensebackendspring.entity.Receipt;

import java.util.Optional;
import java.util.UUID;

public interface ReceiptRepository extends JpaRepository<Receipt, UUID> {

    Page<Receipt> findByUserId(UUID userId, Pageable pageable);

    Optional<Receipt> findByIdAndUserId(UUID id, UUID userId);
}
