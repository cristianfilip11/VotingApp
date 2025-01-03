package com.example.demo.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class VotantNotFoundException extends RuntimeException{
    public VotantNotFoundException() {
        //super("Votant not found");
        super(ErrorMessages.VOTANT_NOT_FOUND.getMessage());
    }
}
