package com.stradaperroma.userprogress.controller;

import com.stradaperroma.userprogress.service.UserProgressService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/user-progress")
@RequiredArgsConstructor
@Slf4j
public class UserProgressController {

    private final UserProgressService service;


    @GetMapping("/{userId}/{bookId}")
    @Operation(summary = "Get last open page", description = "Fetches an number of the page by user id and book id")
    public ResponseEntity<Integer> getLastOpenPage(@PathVariable UUID userId, @PathVariable UUID bookId) {
        log.debug("Requested last open page for user {} and book {}", userId, bookId );
        return ResponseEntity.ok(service.getLastOpenPage(userId, bookId));
    }
}
