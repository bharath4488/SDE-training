package com.basics.amazon.learnSpringBoot.exception;

import org.springframework.http.HttpStatus;

import java.time.Instant;
import java.util.Date;

public class ApiErrorResponse {
    private String message;
    private HttpStatus status;
    private Instant timeStamp;

    public ApiErrorResponse(String message, HttpStatus status, Instant timeStamp) {
        this.message = message;
        this.status = status;
        this.timeStamp = timeStamp;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }

    public Instant getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Instant timeStamp) {
        this.timeStamp = timeStamp;
    }
}
