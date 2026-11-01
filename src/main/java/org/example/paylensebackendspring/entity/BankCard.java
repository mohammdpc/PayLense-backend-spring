package org.example.paylensebackendspring.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import org.hibernate.annotations.Check;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.Instant;
import java.util.UUID;

@Entity
@Table(name = "bank_cards")
@Check(constraints = "expiration_month BETWEEN 1 AND 12")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BankCard {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "card_id", nullable = false, updatable = false)
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "account_id", nullable = false)
    private FinancialAccount account;

    @Column(name = "card_token", length = 255)
    private String cardToken;

    @Column(name = "card_fingerprint", nullable = false, length = 255)
    private String cardFingerprint;

    @Column(name = "last4", nullable = false, length = 4)
    private String last4;

    @Column(name = "cardholder_name", length = 100)
    private String cardholderName;

    @Column(name = "expiration_month")
    private Short expirationMonth;

    @Column(name = "expiration_year")
    private Short expirationYear;

    @Column(name = "currency", nullable = false, length = 3)
    private String currency;

    @Column(name = "card_status", nullable = false, length = 20)
    private String cardStatus;

    @Column(name = "is_default", nullable = false)
    private boolean defaultCard;

    @CreationTimestamp
    @Column(name = "created_at", nullable = false, updatable = false)
    private Instant createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at", nullable = false)
    private Instant updatedAt;
}
