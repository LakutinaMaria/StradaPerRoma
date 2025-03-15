package com.stradaperroma.bookservice.entity;

import lombok.Getter;

@Getter
public enum BookLevel {
    BEGINNER("Beginner"),
    INTERMEDIATE("Intermediate"),
    ADVANCED("Advanced");


    BookLevel(String name) {
    }
}
