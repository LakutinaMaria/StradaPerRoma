package com.stradaperroma.bookservice.service;

import com.stradaperroma.bookservice.dto.BookDTO;
import com.stradaperroma.bookservice.dto.PageDTO;
import jakarta.validation.Valid;

import java.util.List;
import java.util.UUID;


public interface BookService {

    List<BookDTO> getAllBooks();

    UUID create(BookDTO book);

    UUID createPage(@Valid PageDTO pageDTO);

    PageDTO getPage(UUID bookId, Integer cursor);

}
