package org.example.paylensebackendspring.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import org.example.paylensebackendspring.entity.Bill;

import java.util.Optional;
import java.util.UUID;

public interface BillRepository extends JpaRepository<Bill, UUID> {

    Optional<Bill> findByPublicTokenHash(String publicTokenHash);

    Page<Bill> findByCreatorId(UUID creatorId, Pageable pageable);
}
