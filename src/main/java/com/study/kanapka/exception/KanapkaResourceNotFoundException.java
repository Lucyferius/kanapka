package com.study.kanapka.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class KanapkaResourceNotFoundException extends RuntimeException{
    public KanapkaResourceNotFoundException() {
        super();
    }
    public KanapkaResourceNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
    public KanapkaResourceNotFoundException(String message) {
        super(message);
    }
    public KanapkaResourceNotFoundException(Throwable cause) {
        super(cause);
    }
}