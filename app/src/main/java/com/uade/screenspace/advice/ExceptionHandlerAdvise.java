package com.uade.screenspace.advice;

import com.uade.screenspace.exceptions.DuplicatedEntity;
import com.uade.screenspace.exceptions.EntityNotFound;
import com.uade.screenspace.exceptions.ValidationError;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ExceptionHandlerAdvise extends ResponseEntityExceptionHandler {

    @ExceptionHandler(EntityNotFound.class)
    public ResponseEntity<?> handleEntityNotFound(EntityNotFound ex){
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(new ExMessage(ex.getMessage()));
    }

    @ExceptionHandler(DuplicatedEntity.class)
    public ResponseEntity<?> handleDuplicatedEntity(DuplicatedEntity ex){
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(new ExMessage(ex.getMessage()));
    }

    @ExceptionHandler(ValidationError.class)
    public ResponseEntity<?> handleValidationError(ValidationError ex){
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(new ExMessage(ex.getMessage()));
    }

    public static class ExMessage {

       private final String message;

        public ExMessage(String message) {
            this.message = message;
        }

        public String getMessage() {
            return message;
        }
    }
}
