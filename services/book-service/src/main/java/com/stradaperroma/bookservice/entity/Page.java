package com.stradaperroma.bookservice.entity;

import jakarta.persistence.*;
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

    private Integer pageNumber;

    @Column(length = 5000)
    private String content;

    public Page() {}

    @Builder
    public Page(UUID pageId, Integer pageNumber, String content) {
        this.pageId = pageId;
        this.pageNumber = pageNumber;
        this.content = content;
    }
}