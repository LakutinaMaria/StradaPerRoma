package com.stradaperroma.bookservice.controller;

import com.stradaperroma.bookservice.dto.BookDTO;
import com.stradaperroma.bookservice.dto.PageDTO;
import com.stradaperroma.bookservice.service.BookService;

import io.swagger.v3.oas.annotations.Operation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/books")
@Tag(name = "Books", description = "Endpoints for working with books")
@RequiredArgsConstructor
@Slf4j
public class BookController {

    private final BookService service;

    @GetMapping
    @Operation(summary = "Get all books", description = "Fetches a list of all available books")
    public List<BookDTO> getAllBooks() {
        log.debug("Get all books");
        return service.getAllBooks();
    }


    @PostMapping
    public ResponseEntity<String> createBook(@RequestBody @Valid BookDTO book) {
        UUID createdBookId = service.create(book);
        return ResponseEntity.ok(createdBookId.toString());
    }

    @GetMapping("/{bookId}/{cursor}")
    @Operation(summary = "Get page by book id and user id")
    public ResponseEntity<PageDTO> getPage(@PathVariable UUID bookId, @PathVariable Integer cursor) {
        log.debug("Get page for " + bookId + "  " + cursor);
        return ResponseEntity.ok(service.getPage(bookId, cursor));
    }


    @PostMapping("/page")
    public ResponseEntity<String> createPage(@RequestBody @Valid PageDTO pageDTO) {
        log.debug("Create page: {}", pageDTO);
        UUID createdPageId = service.createPage(pageDTO);
        return ResponseEntity.ok(createdPageId.toString());
    }

}
