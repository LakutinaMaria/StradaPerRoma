package com.stradaperroma.bookservice.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Entity
@Table(name = "pages")
@Builder
@Data
public class Page {
    @Id
    @GeneratedValue
    private UUID pageId;

    private UUID bookId;

    private Integer pageNumber;

    private String content;

    public Page() {}

    @Builder
    public Page(UUID pageId, UUID bookId, Integer pageNumber, String content) {
        this.pageId = pageId;
        this.bookId = bookId;
        this.pageNumber = pageNumber;
        this.content = content;
    }
}