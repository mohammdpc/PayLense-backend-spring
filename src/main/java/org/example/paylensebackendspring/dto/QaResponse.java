package org.example.paylensebackendspring.dto;

import org.example.paylensebackendspring.entity.QaTranslation;

public record QaResponse(
        Integer id,
        String language,
        String topic,
        String question,
        String answer
) {
    public static QaResponse from(QaTranslation e) {
        return new QaResponse(
                e.getId().getQaId(),
                e.getId().getLanguage(),
                e.getQaItem().getTopic(),
                e.getQuestion(),
                e.getAnswer()
        );
    }
}
