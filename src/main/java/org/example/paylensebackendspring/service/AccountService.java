package org.example.paylensebackendspring.service;

import lombok.RequiredArgsConstructor;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import org.example.paylensebackendspring.dto.AccountBalanceResponse;
import org.example.paylensebackendspring.dto.AccountResponse;
import org.example.paylensebackendspring.dto.CreateAccountRequest;
import org.example.paylensebackendspring.dto.LedgerEntryResponse;
import org.example.paylensebackendspring.dto.PageResponse;
import org.example.paylensebackendspring.entity.FinancialAccount;
import org.example.paylensebackendspring.enums.EntryType;
import org.example.paylensebackendspring.exception.ResourceNotFoundException;
import org.example.paylensebackendspring.repository.FinancialAccountRepository;
import org.example.paylensebackendspring.repository.LedgerEntryRepository;
import org.example.paylensebackendspring.repository.UserRepository;
import org.example.paylensebackendspring.util.Paging;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AccountService {

    private final FinancialAccountRepository accountRepository;
    private final LedgerEntryRepository ledgerEntryRepository;
    private final UserRepository userRepository;

    @Transactional
    public AccountResponse create(UUID userId, CreateAccountRequest request) {
        FinancialAccount account = accountRepository.save(FinancialAccount.builder()
                .user(userRepository.getReferenceById(userId))
                .accountName(request.accountName())
                .currency(request.currency())
                .accountStatus("ACTIVE")
                .build());
        return AccountResponse.from(account);
    }

    @Transactional(readOnly = true)
    public List<AccountResponse> list(UUID userId) {
        return accountRepository.findByUserId(userId).stream()
                .map(AccountResponse::from)
                .toList();
    }

    @Transactional(readOnly = true)
    public AccountBalanceResponse balance(UUID userId, UUID accountId) {
        FinancialAccount account = findOwned(userId, accountId);
        BigDecimal credits = orZero(ledgerEntryRepository.sumAmount(accountId, EntryType.CREDIT));
        BigDecimal debits = orZero(ledgerEntryRepository.sumAmount(accountId, EntryType.DEBIT));
        return new AccountBalanceResponse(account.getId(), account.getCurrency(), credits.subtract(debits));
    }

    @Transactional(readOnly = true)
    public PageResponse<LedgerEntryResponse> statement(UUID userId, UUID accountId, int page, int size) {
        findOwned(userId, accountId);
        Page<LedgerEntryResponse> result = ledgerEntryRepository
                .findByAccountIdOrderByCreatedAtDesc(accountId, Paging.of(page, size))
                .map(LedgerEntryResponse::from);
        return PageResponse.from(result);
    }

    private FinancialAccount findOwned(UUID userId, UUID accountId) {
        return accountRepository.findByIdAndUserId(accountId, userId)
                .orElseThrow(() -> new ResourceNotFoundException("Account not found"));
    }

    private BigDecimal orZero(BigDecimal value) {
        return value == null ? BigDecimal.ZERO : value;
    }
}
