package com.example.demo.Exceptions;

import com.example.demo.Votant.Model.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GlobalExceptionHandler {


    @ExceptionHandler(VotantNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ResponseBody
    public ErrorResponse handleVotantNotFoundException(VotantNotFoundException exception){
        return new ErrorResponse(exception.getMessage());

    }
    //acelasi cod dar scris altfel
    /*@ExceptionHandler(VotantNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleVotantNotFoundException(VotantNotFoundException exception){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorResponse(exception.getMessage()));

    }*/
    @ExceptionHandler(VotantNotValidException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse handleVotantNotValidException(VotantNotValidException exception){
        return new ErrorResponse(exception.getMessage());
    }

    //Can add more exceptions to be handled here
}
