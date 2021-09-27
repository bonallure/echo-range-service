package com.company.echorangeservice.controller;

import com.company.echorangeservice.model.CustomErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

/**
 * Created by bonallure on 9/21/21
 */

@RestControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(value = IllegalArgumentException.class)
    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    public ResponseEntity<CustomErrorResponse> handleGenericNotFoundException(IllegalArgumentException e){
        HttpStatus status = HttpStatus.UNPROCESSABLE_ENTITY;

        CustomErrorResponse error = new CustomErrorResponse(status.toString(), e.getMessage());
        error.setStatus(status.value());
        error.setTimestamp(LocalDateTime.now());

        ResponseEntity<CustomErrorResponse> responseResponseEntity = new ResponseEntity<>(error, status);

        return responseResponseEntity;
    }
}
