package org.example.paylensebackendspring.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Embeddable
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class QaTranslationId implements Serializable {

    @Column(name = "qa_id", nullable = false)
    private Integer qaId;

    @Column(name = "language", nullable = false, length = 10)
    private String language;
}
