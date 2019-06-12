package com.robosh.model.exceptions;

public class EmailIsAlreadyTaken extends Exception {
    public EmailIsAlreadyTaken() {
        super();
    }

    public EmailIsAlreadyTaken(String message) {
        super(message);
    }

    public EmailIsAlreadyTaken(String message, Throwable cause) {
        super(message, cause);
    }

    public EmailIsAlreadyTaken(Throwable cause) {
        super(cause);
    }
}
