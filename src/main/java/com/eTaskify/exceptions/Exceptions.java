package com.eTaskify.exceptions;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.validation.ConstraintViolationException;

@ControllerAdvice
public class Exceptions {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<?> HttpMessageNotReadableException(HttpMessageNotReadableException e) {
        return ResponseEntity.badRequest().build();
    }


    @ResponseBody
    @ResponseStatus(HttpStatus.LENGTH_REQUIRED)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> NotFoundException(MethodArgumentNotValidException e) {
        return ResponseEntity.status(HttpStatus.LENGTH_REQUIRED)
                .body("The length of the password must be at least 6 characters");
    }

    @ResponseStatus(HttpStatus.ALREADY_REPORTED)
    @ResponseBody
    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<?> DataIntegrityViolationException(DataIntegrityViolationException e) {
        return ResponseEntity.status(HttpStatus.ALREADY_REPORTED).body("Your email has been registered");
    }

    @ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
    @ResponseBody
    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<?> ConstraintViolationException(ConstraintViolationException e) {
        return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body("Field cannot be empty");
    }
}
