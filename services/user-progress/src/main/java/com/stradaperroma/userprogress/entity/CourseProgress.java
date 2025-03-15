package com.stradaperroma.userprogress.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

import java.util.UUID;

@Data
@Entity
public class CourseProgress {

    @Id
    @GeneratedValue
    UUID id;
    UUID courseId;
    UUID userId;

}
