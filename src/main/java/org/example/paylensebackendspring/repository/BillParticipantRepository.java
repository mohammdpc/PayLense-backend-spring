package org.example.paylensebackendspring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.example.paylensebackendspring.entity.BillParticipant;
import org.example.paylensebackendspring.entity.BillParticipantId;

import java.util.List;
import java.util.UUID;

public interface BillParticipantRepository extends JpaRepository<BillParticipant, BillParticipantId> {

    List<BillParticipant> findByIdBillId(UUID billId);

    List<BillParticipant> findByIdUserId(UUID userId);
}
