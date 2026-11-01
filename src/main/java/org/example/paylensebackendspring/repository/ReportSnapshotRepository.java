package org.example.paylensebackendspring.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import org.example.paylensebackendspring.entity.ReportSnapshot;

import java.util.UUID;

public interface ReportSnapshotRepository extends JpaRepository<ReportSnapshot, UUID> {

    Page<ReportSnapshot> findByUserIdOrderByGeneratedAtDesc(UUID userId, Pageable pageable);
}
