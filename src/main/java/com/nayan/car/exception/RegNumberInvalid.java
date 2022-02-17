package com.nayan.car.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value= HttpStatus.BAD_REQUEST)
public class RegNumberInvalid extends RuntimeException{
    public RegNumberInvalid(String message) {
        super(message);
    }
}
