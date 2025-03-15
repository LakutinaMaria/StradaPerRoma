package com.stradaperroma.bookservice.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.UUID;


@Entity
@Data
public class Book {


    @Id
    @GeneratedValue
    private UUID id;
    private String title;
    private String author;
    private String coverUrl;
    @Enumerated(EnumType.STRING)
    @Column(name = "level", columnDefinition = "book_level")
    private BookLevel level;
    @OneToMany
    private List<Page> pages;
    private Integer pageSize;


}
