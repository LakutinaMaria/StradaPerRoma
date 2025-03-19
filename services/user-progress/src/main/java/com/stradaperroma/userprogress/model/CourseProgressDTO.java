package com.stradaperroma.userprogress.model;

import lombok.Data;

import java.util.UUID;

@Data
public class CourseProgressDTO {

    UUID id;
    UUID courseId;
    UUID userId;
}
