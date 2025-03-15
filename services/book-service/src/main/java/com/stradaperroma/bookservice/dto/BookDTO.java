package com.stradaperroma.bookservice.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.UUID;

@Data
public class BookDTO {

    private UUID id;
    @NotNull(message = "Book title is required")
    private String title;
    private String author;
    private String level;
    private String coverUrl;
    private Boolean started = false;
    private Integer pageSize;

}
