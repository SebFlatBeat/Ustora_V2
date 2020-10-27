package com.Ustora.book.exceptions;

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
                case "AddBorrowingException":
                    return new AddBorrowingException("AddBorrowingException");
                case "AddReservationException":
                    return new AddReservationException("AddReservationException");
                case "AddWaitingListException":
                    return new AddWaitingListException("AddWaitingListException");
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
