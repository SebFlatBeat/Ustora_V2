package com.Ustora.clientui.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.METHOD_NOT_ALLOWED,reason = "AddWaitingListException")
public class AddWaitingListException extends RuntimeException{
    public AddWaitingListException(String message){
        super(message);
    }
}
