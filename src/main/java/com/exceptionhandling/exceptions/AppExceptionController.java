package com.exceptionhandling.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import java.time.LocalDateTime;

@ControllerAdvice
public class AppExceptionController {

    @ExceptionHandler({DecadevNotFound.class, DecadevAlreadyExist.class})
    public ResponseEntity<AppException> handleExceptions(Exception ex){ // take care of me when failed
        AppException exception = new AppException(
                HttpStatus.BAD_REQUEST.value(),
                HttpStatus.BAD_REQUEST,
                ex.getMessage(),
                LocalDateTime.now()
        );
        return new ResponseEntity<>(exception, HttpStatus.BAD_REQUEST);
    }
}
