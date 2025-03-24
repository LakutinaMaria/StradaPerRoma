package com.stradaperroma.bookservice.repository;

import com.stradaperroma.bookservice.entity.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface PageRepository extends JpaRepository<Page, UUID> {

    @Query("SELECT p FROM Book b JOIN b.pages p WHERE b.id = :bookId AND p.pageNumber = :pageNumber")
    Optional<Page> findPageByBookIdAndPageNumber(@Param("bookId") UUID bookId, @Param("pageNumber") int pageNumber);
}
