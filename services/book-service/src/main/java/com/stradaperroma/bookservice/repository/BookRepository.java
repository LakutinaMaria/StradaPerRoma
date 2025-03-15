package com.stradaperroma.bookservice.repository;

import com.stradaperroma.bookservice.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;


@Repository
public interface BookRepository extends JpaRepository<Book, UUID> {
}
