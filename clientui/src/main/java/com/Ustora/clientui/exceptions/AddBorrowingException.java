package com.Ustora.clientui.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.UNPROCESSABLE_ENTITY,reason = "AddBorrowingException")
public class AddBorrowingException extends RuntimeException{
    public AddBorrowingException(String message){
        super(message);
    }
}
