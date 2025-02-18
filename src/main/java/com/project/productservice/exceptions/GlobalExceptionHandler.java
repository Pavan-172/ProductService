package com.project.productservice.exceptions;

import com.project.productservice.dtos.ErrorDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(Exception.class)
    public ErrorDto NUllPointExceptionHandler(){
        ErrorDto errorDto = new ErrorDto();
        errorDto.setMessage("Null pointer exception");
        errorDto.setStatus("failure");
        return errorDto;
    }

    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<ErrorDto> ProductNotFoundException(ProductNotFoundException exception){
        ErrorDto errorDto = new ErrorDto();
        errorDto.setMessage(exception.getMessage());
        errorDto.setStatus("failure");

        return new ResponseEntity<>(errorDto, HttpStatus.NOT_FOUND);
    }
}
