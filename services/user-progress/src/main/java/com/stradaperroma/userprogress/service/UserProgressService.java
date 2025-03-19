package com.stradaperroma.userprogress.service;

import com.stradaperroma.userprogress.entity.BookProgress;
import com.stradaperroma.userprogress.model.BookProgressDTO;

public interface UserProgressService {

   BookProgressDTO createBookProgress(BookProgressDTO dto);
}
