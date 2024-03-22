package org.polytech.spring.rest;

import org.polytech.spring.patient.PatientNotFoundException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class AppRestExceptionHandler extends ResponseEntityExceptionHandler {
    
    @Override
    protected ResponseEntity<Object> handleHttpMediaTypeNotSupported(HttpMediaTypeNotSupportedException ex,
            HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        ResponseEntity<Object> entity =  super.handleHttpMediaTypeNotSupported(ex, headers, status, request);
        ApiError apiError = new ApiError(entity.getStatusCode(), ex.getLocalizedMessage(), "error occured");
        return build(apiError, entity.getHeaders());
    }

    @ExceptionHandler({ PatientNotFoundException.class })
    public ResponseEntity<Object> handlePatientException(PatientNotFoundException ex, WebRequest request) {
        ApiError apiError = new ApiError(
        HttpStatus.NOT_FOUND, ex.getLocalizedMessage(), "Patient introuvable");
        return build(apiError, null);
    }

    public ResponseEntity<Object> build(ApiError apiError, HttpHeaders headers){
        return ResponseEntity.status(apiError.getStatus()).headers(headers).body(apiError);        
    }
}
