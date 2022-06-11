package com.study.kanapka.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class KanapkaInvalidInputException extends RuntimeException{
    public KanapkaInvalidInputException() {
        super();
    }
    public KanapkaInvalidInputException(String message, Throwable cause) {
        super(message, cause);
    }
    public KanapkaInvalidInputException(String message) {
        super(message);
    }
    public KanapkaInvalidInputException(Throwable cause) {
        super(cause);
    }
}
