package com.example.demo.dto;

import java.util.List;

import lombok.Data;

@Data
public class ErrorResponse {

    private List<ErrorDetails> errors;

    @Data
    public static class ErrorDetails {
        private String fieldName;
        private String message;
    }
}