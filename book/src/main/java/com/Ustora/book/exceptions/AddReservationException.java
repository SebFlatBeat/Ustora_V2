package com.Ustora.book.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.METHOD_NOT_ALLOWED)
public class AddReservationException extends RuntimeException{
    public AddReservationException(String message){
        super(message);
    }
}
