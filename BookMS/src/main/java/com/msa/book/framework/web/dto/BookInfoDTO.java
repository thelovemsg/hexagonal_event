package com.msa.book.framework.web.dto;

import lombok.Getter;

import java.time.LocalDate;

@Getter
public class BookInfoDTO {
    private String title;
    private String description;
    private String author;
    private String isbn;
    private LocalDate publicDate;
    private String source;
    private String classification;
    private String location;
}