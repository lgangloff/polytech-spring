package org.polytech.spring.rest;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpStatusCode;

public class ApiError {

    private HttpStatusCode status;
    private String message;
    private List<String> errors;

    public ApiError(HttpStatusCode status, List<String> errors, String message) {
        super();
        this.status = status;
        this.message = message;
        this.errors = errors;
    }

    public ApiError(HttpStatusCode status, String error, String message) {
        super();
        this.status = status;
        this.message = message;
        errors = Arrays.asList(error);
    }

    public HttpStatusCode getStatus() {
        return status;
    }

    public void setStatus(HttpStatusCode status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<String> getErrors() {
        return errors;
    }

    public void setErrors(List<String> errors) {
        this.errors = errors;
    }

    
}