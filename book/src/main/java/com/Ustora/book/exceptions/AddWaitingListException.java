package com.Ustora.book.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.UNAUTHORIZED,reason = "La liste de réservation est complète pour ce livre")
public class AddWaitingListException extends RuntimeException{
    public AddWaitingListException(String message){
        super(message);
    }
}
