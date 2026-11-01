package org.example.paylensebackendspring.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import org.example.paylensebackendspring.entity.LedgerEntry;
import org.example.paylensebackendspring.enums.EntryType;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

public interface LedgerEntryRepository extends JpaRepository<LedgerEntry, Long> {

    Page<LedgerEntry> findByAccountIdOrderByCreatedAtDesc(UUID accountId, Pageable pageable);

    List<LedgerEntry> findByTransactionId(UUID transactionId);

    @Query("SELECT SUM(l.amount) FROM LedgerEntry l WHERE l.account.id = :accountId AND l.entryType = :entryType")
    BigDecimal sumAmount(@Param("accountId") UUID accountId, @Param("entryType") EntryType entryType);
}
