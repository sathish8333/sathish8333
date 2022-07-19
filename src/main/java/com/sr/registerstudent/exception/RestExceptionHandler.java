package com.sr.registerstudent.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolationException;
import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler(value = ConstraintViolationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<ErrorResponse> handleException(ConstraintViolationException ex){
        List<String> details = new ArrayList<>();
        ex.getConstraintViolations().forEach(msg -> details.add(msg.getMessage()));
        ErrorResponse er = new ErrorResponse(details);
        System.out.println("list error ::"+details);
        return new ResponseEntity(er,HttpStatus.BAD_REQUEST);
    }
}
