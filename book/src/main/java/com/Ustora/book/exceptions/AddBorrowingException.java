package com.Ustora.book.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.METHOD_NOT_ALLOWED,reason = "Vous avez déjà un emprunt en cours pour ce livre")
public class AddBorrowingException extends RuntimeException{
    public AddBorrowingException(String message){
        super(message);
    }
}
