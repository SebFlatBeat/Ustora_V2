package com.Ustora.book.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_EXTENDED, reason = "La date de retour est déjà dépassée, vous ne pouvez pas prolonger votre emprunt")
public class NoExtendIfEndBorrowingExceedException extends RuntimeException{
    public NoExtendIfEndBorrowingExceedException(String message){
        super(message);
    }
}
