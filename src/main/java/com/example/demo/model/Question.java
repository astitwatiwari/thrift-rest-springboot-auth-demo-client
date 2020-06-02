package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@lombok.Data
@AllArgsConstructor
@NoArgsConstructor
@Document("question")
public class Question {
    @Id
    String questionId;
    String questionStatement;
    List<String> options;
    int correctOption; // Starts from 0
}
