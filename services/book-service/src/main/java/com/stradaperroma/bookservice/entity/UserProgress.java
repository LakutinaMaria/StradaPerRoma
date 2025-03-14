package com.stradaperroma.bookservice.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.index.CompoundIndexes;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@AllArgsConstructor
@Data
@CompoundIndexes({
        @CompoundIndex(name = "user_book_idx", def = "{'userId': 1, 'bookId': 1}", unique = true)
})
public class UserProgress {

    String bookId;
    String userId;
    Integer lastOpenedPage;
}
