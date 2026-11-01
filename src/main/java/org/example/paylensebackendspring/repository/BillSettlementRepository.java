package org.example.paylensebackendspring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.example.paylensebackendspring.entity.BillSettlement;

import java.util.List;
import java.util.UUID;

public interface BillSettlementRepository extends JpaRepository<BillSettlement, UUID> {

    List<BillSettlement> findByBillId(UUID billId);
}
