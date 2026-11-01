package org.example.paylensebackendspring.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;
import java.util.UUID;

@Entity
@Table(name = "delayed_sends")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DelayedSend {

    @Id
    @Column(name = "transaction_id", nullable = false, updatable = false)
    private UUID id;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @MapsId
    @JoinColumn(name = "transaction_id")
    private Transaction transaction;

    @Column(name = "message_text", length = 250)
    private String messageText;

    @Column(name = "scheduled_at", nullable = false)
    private Instant scheduledAt;

    @Column(name = "receiver_notified_at")
    private Instant receiverNotifiedAt;

    @Column(name = "cancelled_at")
    private Instant cancelledAt;
}
