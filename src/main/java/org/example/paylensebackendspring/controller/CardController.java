package org.example.paylensebackendspring.controller;

import jakarta.validation.Valid;

import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.example.paylensebackendspring.dto.AddCardRequest;
import org.example.paylensebackendspring.dto.CardResponse;
import org.example.paylensebackendspring.security.CurrentUser;
import org.example.paylensebackendspring.service.CardService;

import java.util.List;

@RestController
@RequestMapping("/api/cards")
@RequiredArgsConstructor
public class CardController {

    private final CardService cardService;

    @PostMapping
    public ResponseEntity<CardResponse> add(@AuthenticationPrincipal Jwt jwt,
                                            @Valid @RequestBody AddCardRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(cardService.add(CurrentUser.id(jwt), request));
    }

    @GetMapping
    public List<CardResponse> list(@AuthenticationPrincipal Jwt jwt) {
        return cardService.list(CurrentUser.id(jwt));
    }
}
