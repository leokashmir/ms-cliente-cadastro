package br.com.cliente.api.exceptions;

public class NotFoundDataException extends Exception {

    private final String customMessage;

    public NotFoundDataException(String message, Throwable cause, String msg) {
        super(message, cause);
        this.customMessage = msg;
    }

    public NotFoundDataException(String msg) {
        this.customMessage = msg;
    }


    public String getCustomMessage() {
        return customMessage;
    }
}
