package org.example.paylensebackendspring.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import org.example.paylensebackendspring.entity.MoneyRequest;
import org.example.paylensebackendspring.enums.MoneyRequestStatus;

import java.util.List;
import java.util.UUID;

public interface MoneyRequestRepository extends JpaRepository<MoneyRequest, UUID> {

    Page<MoneyRequest> findByRequesterId(UUID requesterId, Pageable pageable);

    Page<MoneyRequest> findByPayerId(UUID payerId, Pageable pageable);

    List<MoneyRequest> findByPayerIdAndStatus(UUID payerId, MoneyRequestStatus status);
}
