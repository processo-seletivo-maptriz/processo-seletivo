package com.backendagenda.AgendaApplication.dto;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class CustomError {
    private Instant timestamp;
    private Integer status;
    private String error;
    private String path;
    private LocalDateTime localDateTime;
    private LocalDate localDate;

    public CustomError(Instant timestamp, Integer status, String error, String path, LocalDateTime localDateTime, LocalDate localDate) {
        this.timestamp = timestamp;
        this.status = status;
        this.error = error;
        this.path = path;
        this.localDateTime = localDateTime;
        this.localDate = localDate;
    }

    public Instant getTimestamp() {
        return timestamp;
    }

    public Integer getStatus() {
        return status;
    }

    public String getError() {
        return error;
    }

    public String getPath() {
        return path;
    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    public LocalDate getLocalDate() {
        return localDate;
    }
}
