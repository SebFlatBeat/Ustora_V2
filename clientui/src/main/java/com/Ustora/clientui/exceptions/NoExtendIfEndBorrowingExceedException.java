package com.Ustora.clientui.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.METHOD_NOT_ALLOWED, reason = "NoExtendIfEndBorrowingExceedException")
public class NoExtendIfEndBorrowingExceedException extends RuntimeException{
    public NoExtendIfEndBorrowingExceedException(String message){
        super(message);
    }
}
