package com.stradaperroma.userprogress.service;

import com.stradaperroma.userprogress.model.BookProgressDTO;

import java.util.UUID;

public interface UserProgressService {

   BookProgressDTO createBookProgress(BookProgressDTO dto);

   BookProgressDTO getBookProgress(UUID userId, UUID bookId);

   Integer getLastOpenPage(UUID userId, UUID bookId);
}
