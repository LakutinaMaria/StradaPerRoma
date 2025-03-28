package com.stradaperroma.userprogress.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

import java.util.UUID;


@Data
@Entity
public class BookProgress {
    @Id
    @GeneratedValue
    UUID id;
    UUID bookId;
    UUID userId;
    Integer lastOpenedPage;
}
