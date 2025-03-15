package com.stradaperroma.bookservice.service;

import com.stradaperroma.bookservice.dto.BookDTO;
import com.stradaperroma.bookservice.dto.PageDTO;
import com.stradaperroma.bookservice.entity.Book;
import com.stradaperroma.bookservice.entity.Page;
import com.stradaperroma.bookservice.mapper.BookMapper;
import com.stradaperroma.bookservice.mapper.PageMapper;
import com.stradaperroma.bookservice.repository.BookRepository;
import com.stradaperroma.bookservice.repository.PageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;


@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

    private final BookRepository repository;
    private final BookMapper mapper;
    private final PageMapper pageMapper;
    private final PageRepository pageRepository;


    public List<BookDTO> getAllBooks() {
        return repository.findAll()
                .stream()
                .map(mapper::bookToBookDTO)
                .toList();
    }

    public UUID create(BookDTO bookDto) {
        Book book = mapper.bookDTOToBook(bookDto);
        return repository.save(book).getId();
    }

    @Override
    public UUID createPage(PageDTO pageDTO) {
        Page page = pageMapper.createPageFromDTO(pageDTO);
        return pageRepository.save(page).getPageId();
    }


    @Override
    public PageDTO getPage(UUID bookId, Integer cursor) {
        Page page = pageRepository.findPageByBookIdAndPageNumber(bookId, cursor).orElseThrow();
      return pageMapper.pageToDTO(page);

    }


}
