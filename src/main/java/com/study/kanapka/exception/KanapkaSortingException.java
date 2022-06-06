package com.study.kanapka.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class KanapkaSortingException extends RuntimeException{
    public KanapkaSortingException() {
        super();
    }
    public KanapkaSortingException(String message, Throwable cause) {
        super(message, cause);
    }
    public KanapkaSortingException(String message) {
        super(message);
    }
    public KanapkaSortingException(Throwable cause) {
        super(cause);
    }
}
