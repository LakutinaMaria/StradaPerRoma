package com.stradaperroma.bookservice.repository;

import com.stradaperroma.bookservice.entity.UserProgress;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserProgressRepository extends MongoRepository<UserProgress, String> {

    Optional<UserProgress> findByUserIdAndBookId(String userId, String bookId);

}
