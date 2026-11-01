package org.example.paylensebackendspring.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.UUID;

@Embeddable
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class BillParticipantId implements Serializable {

    @Column(name = "bill_id", nullable = false)
    private UUID billId;

    @Column(name = "user_id", nullable = false)
    private UUID userId;
}
