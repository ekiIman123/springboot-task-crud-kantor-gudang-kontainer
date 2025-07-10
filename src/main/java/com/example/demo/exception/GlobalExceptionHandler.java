package com.example.demo.exception;

import com.example.demo.response.DefaultResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<DefaultResponse> handleNotFoundException(NotFoundException ex) {
        return ResponseEntity.status(404).body(new DefaultResponse(ex.getMessage()));
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<DefaultResponse> handleOtherExceptions(Exception ex) {
        return ResponseEntity.status(500).body(new DefaultResponse("Internal Server Error: " + ex.getMessage()));
    }
}
