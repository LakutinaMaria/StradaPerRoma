package com.stradaperroma.userprogress.repository;

import com.stradaperroma.userprogress.entity.BookProgress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface BookProgressRepository extends JpaRepository<BookProgress, UUID> {

    Optional<BookProgress> findByUserIdAndBookId(UUID userId, UUID bookId);

}
