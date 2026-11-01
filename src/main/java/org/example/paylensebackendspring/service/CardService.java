package org.example.paylensebackendspring.service;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import org.example.paylensebackendspring.dto.AddCardRequest;
import org.example.paylensebackendspring.dto.CardResponse;
import org.example.paylensebackendspring.entity.BankCard;
import org.example.paylensebackendspring.entity.FinancialAccount;
import org.example.paylensebackendspring.exception.DuplicateResourceException;
import org.example.paylensebackendspring.exception.ResourceNotFoundException;
import org.example.paylensebackendspring.repository.BankCardRepository;
import org.example.paylensebackendspring.repository.FinancialAccountRepository;
import org.example.paylensebackendspring.repository.UserRepository;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HexFormat;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CardService {

    private final BankCardRepository cardRepository;
    private final FinancialAccountRepository accountRepository;
    private final UserRepository userRepository;

    @Transactional
    public CardResponse add(UUID userId, AddCardRequest request) {
        FinancialAccount account = accountRepository.findByIdAndUserId(request.accountId(), userId)
                .orElseThrow(() -> new ResourceNotFoundException("Account not found"));

        String fingerprint = fingerprint(request.cardToken());
        if (cardRepository.existsByUserIdAndCardFingerprint(userId, fingerprint)) {
            throw new DuplicateResourceException("Card is already added");
        }

        boolean firstCard = cardRepository.countByUserId(userId) == 0;

        BankCard card = cardRepository.save(BankCard.builder()
                .user(userRepository.getReferenceById(userId))
                .account(account)
                .cardToken(request.cardToken())
                .cardFingerprint(fingerprint)
                .last4(request.last4())
                .cardholderName(request.cardholderName())
                .expirationMonth(request.expirationMonth())
                .expirationYear(request.expirationYear())
                .currency(request.currency())
                .cardStatus("ACTIVE")
                .defaultCard(firstCard)
                .build());

        return CardResponse.from(card);
    }

    @Transactional(readOnly = true)
    public List<CardResponse> list(UUID userId) {
        return cardRepository.findByUserId(userId).stream()
                .map(CardResponse::from)
                .toList();
    }

    private String fingerprint(String cardToken) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(cardToken.getBytes(StandardCharsets.UTF_8));
            return HexFormat.of().formatHex(hash);
        } catch (NoSuchAlgorithmException e) {
            throw new IllegalStateException("SHA-256 is not available", e);
        }
    }
}
