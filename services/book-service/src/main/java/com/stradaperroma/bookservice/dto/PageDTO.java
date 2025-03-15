package com.stradaperroma.bookservice.dto;

import lombok.Data;

import java.util.UUID;

@Data
public class PageDTO {

    UUID pageId;
    UUID bookId;
    Integer pageNumber;
    String content;


}
