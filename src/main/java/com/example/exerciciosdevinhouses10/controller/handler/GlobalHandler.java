package com.example.exerciciosdevinhouses10.controller.handler;


import com.example.exerciciosdevinhouses10.exception.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalHandler {


    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<String> tratarNotFoundException(Exception e){
        return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
    }
}
