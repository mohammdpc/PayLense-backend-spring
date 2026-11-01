package org.example.paylensebackendspring.entity;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "qa_translations")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class QaTranslation {

    @EmbeddedId
    @Builder.Default
    private QaTranslationId id = new QaTranslationId();

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @MapsId("qaId")
    @JoinColumn(name = "qa_id", nullable = false)
    private QaItem qaItem;

    @Column(name = "question", nullable = false, length = 1000)
    private String question;

    @Column(name = "answer", nullable = false, columnDefinition = "TEXT")
    private String answer;
}
