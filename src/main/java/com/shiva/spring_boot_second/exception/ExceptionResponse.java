package com.shiva.spring_boot_second.exception;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class ExceptionResponse {
    
    private String message;
    private LocalDateTime timestamp; 
}
