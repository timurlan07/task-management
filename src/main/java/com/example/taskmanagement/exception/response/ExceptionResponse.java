package com.example.taskmanagement.exception.response;

import org.springframework.http.HttpStatus;

/**
 * Класс DTO для показа данных бизнес исключений.
 */

public record ExceptionResponse(HttpStatus httpStatus,
                                String exceptionName,
                                String message) {
}
