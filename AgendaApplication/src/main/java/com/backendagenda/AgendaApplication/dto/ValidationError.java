package com.backendagenda.AgendaApplication.dto;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ValidationError extends CustomError{
    private  List<FieldMessage> errors = new ArrayList<>();

    public ValidationError(Instant timestamp, Integer status, String error, String path, LocalDateTime localDateTime, LocalDate localDate) {
        super(timestamp, status, error, path, localDateTime, localDate);
    }

    public List<FieldMessage> getErrors() {
        return errors;
    }

    public void addError(String fieldName, String message) {
        errors.removeIf(x -> x.getFieldName().equals(fieldName));
        errors.add(new FieldMessage(fieldName, message));
    }
}
