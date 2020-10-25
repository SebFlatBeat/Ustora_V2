package com.Ustora.book.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.METHOD_NOT_ALLOWED)
public class AddBorrowingException extends RuntimeException{
    public AddBorrowingException(String message){
        super(message);
    }
}
