package br.com.cliente.api.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


public class InvalidDataException extends Exception {

    private final String customMessage;

    public InvalidDataException(String message, Throwable cause, String msg) {
        super(message, cause);
        this.customMessage = msg;
    }

    public InvalidDataException(String msg) {
        this.customMessage = msg;
    }

    public String getCustomMessage() {
        return customMessage;
    }
}
