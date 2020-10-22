package com.Ustora.book.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.UNAUTHORIZED)
public class AddBorrowingException extends RuntimeException{
    public AddBorrowingException(String message){
        super(message);
    }
}
