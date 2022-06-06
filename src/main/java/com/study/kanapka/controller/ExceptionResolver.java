package com.study.kanapka.controller;

import com.study.kanapka.exception.KanapkaResourceNotFoundException;
import com.study.kanapka.exception.KanapkaSortingException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.util.HashMap;

@RestControllerAdvice
public class ExceptionResolver {

    @ExceptionHandler(KanapkaResourceNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public HashMap<String, String> handleNoHandlerFound(KanapkaResourceNotFoundException e, WebRequest request) {
        HashMap<String, String> response = new HashMap<>();
        response.put("status", String.valueOf(HttpStatus.NOT_FOUND.value()));
        response.put("reasonPhrase", HttpStatus.NOT_FOUND.getReasonPhrase());
        response.put("message", e.getLocalizedMessage());
        return response;
    }

    @ExceptionHandler(KanapkaSortingException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public HashMap<String, String> handleSortingException(KanapkaSortingException e, WebRequest request) {
        HashMap<String, String> response = new HashMap<>();
        response.put("status", String.valueOf(HttpStatus.BAD_REQUEST.value()));
        response.put("reasonPhrase", HttpStatus.BAD_REQUEST.getReasonPhrase());
        response.put("message", e.getLocalizedMessage());
        return response;
    }

    @ExceptionHandler({Error.class})
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public HashMap<String, String> handleServiceError(Error e, WebRequest request) {
        HashMap<String, String> response = new HashMap<>();
        response.put("status", String.valueOf(HttpStatus.INTERNAL_SERVER_ERROR.value()));
        response.put("reasonPhrase", HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase());
        response.put("message", e.getMessage());
        return response;
    }
}
