package com.stradaperroma.userprogress.service.impl;

import com.stradaperroma.userprogress.entity.BookProgress;
import com.stradaperroma.userprogress.model.BookProgressDTO;
import com.stradaperroma.userprogress.repository.BookProgressRepository;
import com.stradaperroma.userprogress.service.UserProgressService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserProgressServiceImpl implements UserProgressService {

    private final BookProgressRepository bookProgressRepository;
    @Override
    public BookProgressDTO createBookProgress(BookProgressDTO dto) {
        //TODO
        return null;
    }

    @Override
    public BookProgressDTO getBookProgress(UUID userId, UUID bookId) {
        return null;
    }

    @Override
    public Integer getLastOpenPage(UUID userId, UUID bookId) {
        return bookProgressRepository.findByUserIdAndBookId(userId, bookId)
                .map(BookProgress::getLastOpenedPage)
                .orElse(1);
    }
}
