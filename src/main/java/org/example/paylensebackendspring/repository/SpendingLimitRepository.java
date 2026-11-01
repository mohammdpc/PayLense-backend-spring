package org.example.paylensebackendspring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.example.paylensebackendspring.entity.SpendingLimit;

import java.util.List;
import java.util.UUID;

public interface SpendingLimitRepository extends JpaRepository<SpendingLimit, Long> {

    List<SpendingLimit> findByUserIdAndActiveTrue(UUID userId);
}
