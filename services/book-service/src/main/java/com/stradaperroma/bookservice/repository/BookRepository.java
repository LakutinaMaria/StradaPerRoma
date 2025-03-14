package com.stradaperroma.bookservice.repository;

import com.stradaperroma.bookservice.entity.Book;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface BookRepository extends MongoRepository<Book, String> {
}
