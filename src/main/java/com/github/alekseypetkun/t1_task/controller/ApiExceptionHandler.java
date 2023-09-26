package com.github.alekseypetkun.t1_task.controller;

import com.github.alekseypetkun.t1_task.exception.BedStringRequestException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * Функция Spring для обработки исключений
 */
@RestControllerAdvice
public class ApiExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<String> handlerBadStringRequestException(BedStringRequestException e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
    }
}
