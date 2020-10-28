package com.Ustora.book.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.UNPROCESSABLE_ENTITY, reason = "NoExtendIfEndBorrowingExceedException")
public class NoExtendIfEndBorrowingExceedException extends RuntimeException{
    public NoExtendIfEndBorrowingExceedException(String message){
        super(message);
    }
}
