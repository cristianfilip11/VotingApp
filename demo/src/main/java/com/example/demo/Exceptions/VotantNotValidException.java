package com.example.demo.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class VotantNotValidException extends RuntimeException{

    public VotantNotValidException(String message){
        super(message);
    }
}
