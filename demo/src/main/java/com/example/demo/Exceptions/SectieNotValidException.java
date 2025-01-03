package com.example.demo.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class SectieNotValidException extends RuntimeException{

    public SectieNotValidException(String message){
        super(message);
    }
}
