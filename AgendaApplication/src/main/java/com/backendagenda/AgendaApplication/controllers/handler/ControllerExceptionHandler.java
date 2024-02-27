package com.backendagenda.AgendaApplication.controllers.handler;

import com.backendagenda.AgendaApplication.dto.CustomError;
import com.backendagenda.AgendaApplication.dto.ValidationError;
import com.backendagenda.AgendaApplication.services.exceptions.DatabaseException;
import com.backendagenda.AgendaApplication.services.exceptions.ForbiddenException;
import jakarta.servlet.http.HttpServletRequest;

import com.backendagenda.AgendaApplication.services.exceptions.ResourNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.validation.FieldError;


import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;

@ControllerAdvice
public class ControllerExceptionHandler {
    @ExceptionHandler(ResourNotFoundException.class)
    public ResponseEntity<CustomError> resourNotFound(ResourNotFoundException e, HttpServletRequest request) {
        HttpStatus status = HttpStatus.NOT_FOUND;
        CustomError err = new CustomError(Instant.now(), status.value(), e.getMessage(), request.getRequestURI(), LocalDateTime.now(), LocalDate.now());
        return ResponseEntity.status(status).body(err);
    }
    @ExceptionHandler(DatabaseException.class)
    public ResponseEntity<CustomError> dataBase(DatabaseException e, HttpServletRequest request) {
        HttpStatus status = HttpStatus.BAD_REQUEST;
        CustomError err = new CustomError(Instant.now(), status.value(), e.getMessage(), request.getRequestURI(), LocalDateTime.now(), LocalDate.now());
        return ResponseEntity.status(status).body(err);
    }
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<CustomError> methodArgumentNotValid(MethodArgumentNotValidException e, HttpServletRequest request) {
        HttpStatus status = HttpStatus.UNPROCESSABLE_ENTITY;
        ValidationError err = new ValidationError(Instant.now(), status.value(), "Dados invalidos", request.getRequestURI(), LocalDateTime.now(), LocalDate.now());
        for (FieldError f: e.getBindingResult().getFieldErrors()){
            err.addError(f.getField(), f.getDefaultMessage());
        }
        return ResponseEntity.status(status).body(err);
    }
//    @ExceptionHandler(ForbiddenException.class)
//    public ResponseEntity<CustomError> forbiden(ForbiddenException e, HttpServletRequest request) {
//        HttpStatus status = HttpStatus.FORBIDDEN;
//        CustomError err = new CustomError(Instant.now(), status.value(),LocalDateTime.now(), LocalDate.now(), e.getMessage(), request.getRequestURI(), LocalDateTime.now(), LocalDate.now());
//        return ResponseEntity.status(status).body(err);
//    }
}