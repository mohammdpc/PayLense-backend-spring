package org.example.paylensebackendspring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.example.paylensebackendspring.entity.QaItem;

import java.util.List;

public interface QaItemRepository extends JpaRepository<QaItem, Integer> {

    List<QaItem> findByActiveTrue();
}
