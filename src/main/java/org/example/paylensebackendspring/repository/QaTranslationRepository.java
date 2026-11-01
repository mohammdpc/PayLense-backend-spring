package org.example.paylensebackendspring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.example.paylensebackendspring.entity.QaTranslation;
import org.example.paylensebackendspring.entity.QaTranslationId;

import java.util.List;

public interface QaTranslationRepository extends JpaRepository<QaTranslation, QaTranslationId> {

    List<QaTranslation> findByIdLanguage(String language);
}
