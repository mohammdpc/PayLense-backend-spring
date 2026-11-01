package org.example.paylensebackendspring.controller;

import jakarta.validation.Valid;

import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import org.example.paylensebackendspring.dto.AccountBalanceResponse;
import org.example.paylensebackendspring.dto.AccountResponse;
import org.example.paylensebackendspring.dto.CreateAccountRequest;
import org.example.paylensebackendspring.dto.LedgerEntryResponse;
import org.example.paylensebackendspring.dto.PageResponse;
import org.example.paylensebackendspring.security.CurrentUser;
import org.example.paylensebackendspring.service.AccountService;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/accounts")
@RequiredArgsConstructor
public class AccountController {

    private final AccountService accountService;

    @PostMapping
    public ResponseEntity<AccountResponse> create(@AuthenticationPrincipal Jwt jwt,
                                                  @Valid @RequestBody CreateAccountRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(accountService.create(CurrentUser.id(jwt), request));
    }

    @GetMapping
    public List<AccountResponse> list(@AuthenticationPrincipal Jwt jwt) {
        return accountService.list(CurrentUser.id(jwt));
    }

    @GetMapping("/{id}/balance")
    public AccountBalanceResponse balance(@AuthenticationPrincipal Jwt jwt, @PathVariable UUID id) {
        return accountService.balance(CurrentUser.id(jwt), id);
    }

    @GetMapping("/{id}/statement")
    public PageResponse<LedgerEntryResponse> statement(@AuthenticationPrincipal Jwt jwt,
                                                       @PathVariable UUID id,
                                                       @RequestParam(defaultValue = "0") int page,
                                                       @RequestParam(defaultValue = "20") int size) {
        return accountService.statement(CurrentUser.id(jwt), id, page, size);
    }
}
