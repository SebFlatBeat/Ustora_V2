package com.Ustora.clientui.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.METHOD_NOT_ALLOWED, reason = "AddReservationException")
public class AddReservationException extends RuntimeException{
    public AddReservationException(String message){
        super(message);
    }
}
