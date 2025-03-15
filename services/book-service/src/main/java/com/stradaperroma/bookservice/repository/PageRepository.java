package com.stradaperroma.bookservice.repository;

import com.stradaperroma.bookservice.entity.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface PageRepository extends JpaRepository<Page, UUID> {
    Optional<Page> findPageByBookIdAndPageNumber(UUID bookId, int i);
}
