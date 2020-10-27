package com.Ustora.book.exceptions;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ApiError {
    private String message;
    private String apiCode;

    public ApiError() {
    }

    public ApiError(String message, String apiCode) {
        this.message = message;
        this.apiCode = apiCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getApiCode() {
        return apiCode;
    }

    public void setApiCode(String apiCode) {
        this.apiCode = apiCode;
    }
}
