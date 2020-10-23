package com.Ustora.book.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.METHOD_NOT_ALLOWED,reason = "La liste de réservation est complète pour ce livre")
public class AddWaitingListException extends RuntimeException{
    public AddWaitingListException(String message){
        super(message);
    }
}
