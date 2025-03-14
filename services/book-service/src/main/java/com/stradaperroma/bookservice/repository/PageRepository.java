package com.stradaperroma.bookservice.repository;

import com.stradaperroma.bookservice.entity.Page;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;
@Repository
public interface PageRepository extends MongoRepository<Page, String> {
    Optional<Page> findPageByBookIdAndPageNumber(String bookId, int i);
}
