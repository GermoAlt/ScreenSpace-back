package com.uade.screenspace.advice;

import com.uade.screenspace.exceptions.EntityNotFound;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHandlerAdvise {

    @ExceptionHandler(EntityNotFound.class)
    public ResponseEntity<?> handleEntityNotFound(EntityNotFound ex){
        return ResponseEntity
                .status(HttpStatus.NOT_EXTENDED)
                .body(ex.getMessage());
    }

}
