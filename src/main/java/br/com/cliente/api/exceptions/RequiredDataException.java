package br.com.cliente.api.exceptions;


public class RequiredDataException extends Exception{

    private final String customMessage;

    public RequiredDataException(String message, Throwable cause, String msg) {
        super(message, cause);
        this.customMessage = msg;
    }

    public RequiredDataException(String msg) {
        this.customMessage = msg;
    }

    public String getCustomMessage() {
        return customMessage;
    }
}
