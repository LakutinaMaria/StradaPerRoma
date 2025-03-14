package com.stradaperroma.bookservice.service;

import com.stradaperroma.bookservice.dto.BookDTO;
import com.stradaperroma.bookservice.dto.PageDTO;
import com.stradaperroma.bookservice.entity.Book;
import com.stradaperroma.bookservice.entity.Page;
import com.stradaperroma.bookservice.entity.UserProgress;
import com.stradaperroma.bookservice.mapper.BookMapper;
import com.stradaperroma.bookservice.mapper.PageMapper;
import com.stradaperroma.bookservice.repository.BookRepository;
import com.stradaperroma.bookservice.repository.PageRepository;
import com.stradaperroma.bookservice.repository.UserProgressRepository;
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
    private final UserProgressRepository userProgressRepository;


    public List<BookDTO> getAllBooks() {
        return repository.findAll()
                .stream()
                .map(mapper::bookToBookDTO)
                .toList();
    }

    public String create(BookDTO bookDto) {
        Book book = mapper.bookDTOToBook(bookDto);
        return repository.save(book).getId();
    }

    @Override
    public String createPage(PageDTO pageDTO) {
        pageDTO.setPageId(UUID.randomUUID().toString());
        Page page = pageMapper.createPageFromDTO(pageDTO);
        return pageRepository.save(page).pageId();
    }

    @Override
    public PageDTO getCurrentPage(String bookId, String userId) {
        return getPage(0, bookId, userId);
    }

    @Override
    public PageDTO getNextPage(String bookId, String userId) {
        return getPage(1, bookId, userId);
    }

    @Override
    public PageDTO getPreviousPage(String bookId, String userId) {
        return getPage(-1, bookId, userId);
    }

    private PageDTO getPage(int cursor, String bookId, String userId) {
        Optional<UserProgress> progress = userProgressRepository.findByUserIdAndBookId(userId, bookId);
        Page page;
        if (progress.isEmpty()) {
            page = pageRepository.findPageByBookIdAndPageNumber(bookId, 1).orElseThrow();
            userProgressRepository.save(new UserProgress(bookId, userId, 1));
            return pageMapper.pageToDTO(page);
        } else {
            int pageNumber = progress.get().getLastOpenedPage() + cursor;
            pageNumber = Math.max(pageNumber, 1);
            page = pageRepository.findPageByBookIdAndPageNumber(bookId, pageNumber).orElseThrow();
            userProgressRepository.save(new UserProgress(bookId, userId, pageNumber));


        }
        return pageMapper.pageToDTO(page);
    }


}
