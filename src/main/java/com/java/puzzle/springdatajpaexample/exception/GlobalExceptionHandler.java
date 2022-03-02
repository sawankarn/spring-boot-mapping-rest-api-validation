package com.java.puzzle.springdatajpaexample.exception;

import com.java.puzzle.springdatajpaexample.dto.ApiError;
import com.java.puzzle.springdatajpaexample.dto.ResponseEntityBuilder;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(StudentNotFoundException.class)
    protected ResponseEntity<Object> handleStudentNotFoundException(StudentNotFoundException ex){
        List<String> errorList = new ArrayList<>();
        errorList.add(ex.getMessage());
        ApiError apiError = ApiError.builder()
                .timestamp(LocalDateTime.now())
                .errors(errorList)
                .message("Student not found.")
                .status(HttpStatus.NOT_FOUND)
                .build();
        return ResponseEntityBuilder.build(apiError);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                                                                  HttpHeaders headers, HttpStatus status,
                                                                  WebRequest request) {
        List<String> errorList = ex.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(error->error.getDefaultMessage()+" "+error.getObjectName())
                .collect(Collectors.toList());
        ApiError apiError = ApiError.builder()
                .timestamp(LocalDateTime.now())
                .errors(errorList)
                .message("Found validation error.")
                .status(HttpStatus.BAD_REQUEST)
                .build();
        return ResponseEntityBuilder.build(apiError);

    }

    @Override
    protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        List<String> errorList = new ArrayList<>();
        errorList.add(ex.getMessage());
        ApiError apiError = ApiError.builder()
                .timestamp(LocalDateTime.now())
                .errors(errorList)
                .message("Request Body is not in a proper format.")
                .status(HttpStatus.BAD_REQUEST)
                .build();
        return ResponseEntityBuilder.build(apiError);
    }


    @Override
    protected ResponseEntity<Object> handleHttpMediaTypeNotSupported(HttpMediaTypeNotSupportedException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        List<String> errorList = new ArrayList<>();
        errorList.add(ex.getMessage());
        ApiError apiError = ApiError.builder()
                .timestamp(LocalDateTime.now())
                .errors(errorList)
                .message("Media type is not supported.")
                .status(HttpStatus.BAD_REQUEST)
                .build();
        return ResponseEntityBuilder.build(apiError);
    }


    @Override
    protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        List<String> errorList = new ArrayList<>();
        errorList.add(ex.getMessage());
        ApiError apiError = ApiError.builder()
                .timestamp(LocalDateTime.now())
                .errors(errorList)
                .message("Request method is not supported.")
                .status(HttpStatus.BAD_REQUEST)
                .build();
        return ResponseEntityBuilder.build(apiError);
    }

    @ExceptionHandler(Exception.class)
    protected ResponseEntity<Object> handleAllException(Exception ex, WebRequest request){
        List<String> errorList = new ArrayList<>();
        errorList.add(ex.getMessage());
        ApiError apiError = ApiError.builder()
                .timestamp(LocalDateTime.now())
                .errors(errorList)
                .message("Other type of exception occurs.")
                .status(HttpStatus.BAD_REQUEST)
                .build();
        return ResponseEntityBuilder.build(apiError);
    }


}
