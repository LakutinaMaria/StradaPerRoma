package com.stradaperroma.bookservice.dto;

import lombok.Data;

@Data
public class PageDTO {

    String pageId;
    String bookId;
    Integer pageNumber;
    String content;


}
