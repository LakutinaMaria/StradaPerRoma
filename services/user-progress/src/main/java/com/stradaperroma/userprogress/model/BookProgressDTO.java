package com.stradaperroma.userprogress.model;

import lombok.Data;

import java.util.UUID;

@Data
public class BookProgressDTO {
    UUID id;
    UUID bookId;
    UUID userId;
    Integer lastOpenedPage;
}
