package com.shiva.spring_boot_second.exception;

import java.time.LocalDateTime;
import java.time.LocalTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    
    @ExceptionHandler(EmployeeException.class)
    public ResponseEntity<ExceptionResponse> empNotFoundExc(EmployeeException e) {
        ExceptionResponse res = new ExceptionResponse();
        res.setMessage(e.getMessage());
        res.setTimestamp(LocalDateTime.now());

        return new ResponseEntity<ExceptionResponse>(res, HttpStatus.NOT_FOUND);
    }
}
