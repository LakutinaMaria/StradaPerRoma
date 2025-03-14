package com.stradaperroma.bookservice.entity;

import jakarta.persistence.Enumerated;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;


@Document
@AllArgsConstructor
@Data
public class Book {

    @Id
    private String id;
    private String title;
    private String author;
    private String coverUrl;
    @Enumerated
    private BookLevel level;
    private List<Page> pages;
    private Integer pageSize;

}
