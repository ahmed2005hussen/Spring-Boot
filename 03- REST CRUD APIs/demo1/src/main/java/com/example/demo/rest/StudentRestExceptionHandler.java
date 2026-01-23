package com.example.demo.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class StudentRestExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<studentErrorResponse> handleException(studentNotFoundException e) {

        studentErrorResponse sError = new studentErrorResponse();
        sError.setMessage(e.getMessage());
        sError.setStatus(HttpStatus.NOT_FOUND.value());
        sError.setTimestamp(System.currentTimeMillis());

        return new ResponseEntity<>(sError, HttpStatus.NOT_FOUND);
    }

    // for generic error like string rather than integer
    @ExceptionHandler
    public ResponseEntity<studentErrorResponse> handleException(Exception e) {

        studentErrorResponse sError = new studentErrorResponse();
        sError.setMessage(e.getMessage());
        sError.setStatus(HttpStatus.BAD_REQUEST.value());
        sError.setTimestamp(System.currentTimeMillis());

        return new ResponseEntity<>(sError, HttpStatus.BAD_REQUEST);
    }


}
