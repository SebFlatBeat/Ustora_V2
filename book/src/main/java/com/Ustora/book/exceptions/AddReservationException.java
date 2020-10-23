package com.Ustora.book.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.METHOD_NOT_ALLOWED, reason = "Vous avez déjà une reservation en cours pour ce livre")
public class AddReservationException extends RuntimeException{
    public AddReservationException(String message){
        super(message);
    }
}
