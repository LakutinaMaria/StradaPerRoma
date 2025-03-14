package com.stradaperroma.bookservice.service;

import com.stradaperroma.bookservice.dto.BookDTO;
import com.stradaperroma.bookservice.dto.PageDTO;
import jakarta.validation.Valid;

import java.util.List;


public interface BookService {

    List<BookDTO> getAllBooks();

    String create(BookDTO book);

    String createPage(@Valid PageDTO pageDTO);

    PageDTO getCurrentPage(String bookId, String userId);

    PageDTO getNextPage(String bookId, String userId);

    PageDTO getPreviousPage(String bookId, String userId);
}
