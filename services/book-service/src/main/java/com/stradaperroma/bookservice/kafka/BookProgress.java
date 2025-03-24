package com.stradaperroma.bookservice.kafka;

import java.util.UUID;

public record BookProgress(
        UUID userId,
        UUID bookId,
        Integer lastOpenPage
) {
    
}
