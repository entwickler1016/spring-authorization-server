package com.kimblue.auth.api.global.common;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CustomExceptionHandler {

    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity<Result> nullPointerException(NullPointerException ex) {
        Result result = new Result(HttpStatus.INTERNAL_SERVER_ERROR);
        return new ResponseEntity<Result>(result, HttpStatusCode.valueOf(result.getStatus()));
    }

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<Result> entityNotFoundException(EntityNotFoundException ex) {
        Result result = new Result(HttpStatus.NOT_FOUND);
        return new ResponseEntity<Result>(result, HttpStatusCode.valueOf(result.getStatus()));
    }
}
