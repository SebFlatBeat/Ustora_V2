package com.Ustora.clientui.exceptions;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import feign.Response;
import feign.codec.ErrorDecoder;

import java.io.IOException;


public class CustomErrorDecoder implements ErrorDecoder{

    private final ErrorDecoder defaultErrorDecoder = new Default();

    @Override
    public Exception decode(String methodKey, Response response) {

        ObjectMapper objectMapper = new ObjectMapper();

        try{
            ApiError error = objectMapper.readValue(response.body().asInputStream(),ApiError.class);
            switch (error.getMessage()){
                case "UserException":
                    return new UserNotFound("L'utilisateur n'existe pas");
                case "BorrowingException":
                    return new AddBorrowingException("Vous avez déjà un emprunt en cours pour ce livre");
                case "ReservationException":
                    return new AddReservationException("Vous avez déjà une reservation en cours pour ce livre");
                case "WaitingListException":
                    return new AddWaitingListException("La liste de réservation est complète pour ce livre");
                case "NoExtendIfEndBorrowingExceedException":
                    return new NoExtendIfEndBorrowingExceedException("La date de retour est déjà dépassée, vous ne pouvez pas prolonger votre emprunt");
                default: return defaultErrorDecoder.decode(methodKey, response);
            }
        } catch (JsonParseException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return defaultErrorDecoder.decode(methodKey, response);
    }
}
