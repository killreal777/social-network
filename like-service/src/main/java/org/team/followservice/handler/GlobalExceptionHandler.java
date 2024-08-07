package org.team.followservice.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.team.followservice.exception.NoSuchPostException;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(NoSuchPostException.class)
    public ResponseEntity<Object> handleNoSuchPostException(NoSuchPostException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
    }
}
