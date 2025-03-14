package com.stradaperroma.bookservice.entity;

import lombok.Builder;

import java.util.UUID;

@Builder
public record Page(String pageId, String bookId, Integer pageNumber, String content) {
}