package com.stradaperroma.userprogress.service.impl;

import com.stradaperroma.userprogress.model.BookProgressDTO;
import com.stradaperroma.userprogress.repository.BookProgressRepository;
import com.stradaperroma.userprogress.service.UserProgressService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

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
}
