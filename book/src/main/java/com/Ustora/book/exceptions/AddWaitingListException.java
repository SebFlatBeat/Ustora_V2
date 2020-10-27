package com.Ustora.book.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.UNPROCESSABLE_ENTITY)
public class AddWaitingListException extends RuntimeException{
    public AddWaitingListException(String message){
        super(message);
    }
}
