package com.basics.amazon.learnSpringBoot.exception;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.time.Instant;
import java.util.Date;

@Setter
@Getter
public class ApiErrorResponse {
    private String message;
    private HttpStatus status;
    private Instant timeStamp;

    public ApiErrorResponse(String message, HttpStatus status, Instant timeStamp) {
        this.message = message;
        this.status = status;
        this.timeStamp = timeStamp;
    }

}
