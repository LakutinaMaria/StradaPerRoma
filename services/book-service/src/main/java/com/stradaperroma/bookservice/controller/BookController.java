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
        String createdBookId = service.create(book);
        return ResponseEntity.ok(createdBookId);
    }

    @GetMapping("/{bookId}/{userId}")
    @Operation(summary = "Get page by book id and user id")
    public ResponseEntity<PageDTO> getPage(@PathVariable String bookId, @PathVariable String userId) {
        System.out.println("Get page for " + bookId + "  " + userId);
        return ResponseEntity.ok(service.getCurrentPage(bookId, userId));
    }

    @GetMapping("/{bookId}/{userId}/next")
    @Operation(summary = "Get next page by book id and user id")
    public ResponseEntity<PageDTO> getNextPage(@PathVariable String bookId, @PathVariable String userId) {
        System.out.println("Get next page for " + bookId + "  " + userId);
        return ResponseEntity.ok(service.getNextPage(bookId, userId));
    }

    @GetMapping("/{bookId}/{userId}/previous")
    @Operation(summary = "Get previous page by book id and user id")
    public ResponseEntity<PageDTO> getPreviousPage(@PathVariable String bookId, @PathVariable String userId) {
        System.out.println("Get previous page for " + bookId + "  " + userId);
        return ResponseEntity.ok(service.getPreviousPage(bookId, userId));
    }




    @PostMapping("/page")
    public ResponseEntity<String> createPage(@RequestBody @Valid PageDTO pageDTO) {
        String createdPageId = service.createPage(pageDTO);
        return ResponseEntity.ok(createdPageId);
    }

}
