package com.basics.amazon.learnSpringBoot.exception;

import com.basics.amazon.learnSpringBoot.exception.user.UserExceptions;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.Instant;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler({UserExceptions.EmptyUserDetailsException.class})
    public ResponseEntity handleUserSaveException(Exception e) {
        ApiErrorResponse apiErrorResponse =
                new ApiErrorResponse(e.getMessage(),
                        HttpStatus.BAD_REQUEST,
                        Instant.now());
        e.printStackTrace();
        return new ResponseEntity(apiErrorResponse, HttpStatus.BAD_REQUEST);
    }

}
