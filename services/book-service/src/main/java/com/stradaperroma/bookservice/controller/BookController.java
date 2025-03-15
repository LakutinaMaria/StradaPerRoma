package com.stradaperroma.bookservice.controller;

import com.stradaperroma.bookservice.dto.BookDTO;
import com.stradaperroma.bookservice.dto.PageDTO;
import com.stradaperroma.bookservice.service.BookService;

import io.swagger.v3.oas.annotations.Operation;
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
public class BookController {

    private final BookService service;

    @GetMapping
    @Operation(summary = "Get all books", description = "Fetches a list of all available books")
    public List<BookDTO> getAllBooks() {
        System.out.println("Get all books");
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
        System.out.println("Get page for " + bookId + "  " + cursor);
        return ResponseEntity.ok(service.getPage(bookId, cursor));
    }


    @PostMapping("/page")
    public ResponseEntity<String> createPage(@RequestBody @Valid PageDTO pageDTO) {
        UUID createdPageId = service.createPage(pageDTO);
        return ResponseEntity.ok(createdPageId.toString());
    }

}
