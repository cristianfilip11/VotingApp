package com.example.demo.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class SectieNotFoundException extends RuntimeException {
    public SectieNotFoundException(){
        super(ErrorMessages.SECTIE_NOT_FOUND.getMessage());
    }

}
