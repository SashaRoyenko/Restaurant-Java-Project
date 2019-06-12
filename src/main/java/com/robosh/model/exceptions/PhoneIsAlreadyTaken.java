package com.robosh.model.exceptions;

public class PhoneIsAlreadyTaken extends Exception {
    public PhoneIsAlreadyTaken() {
        super();
    }

    public PhoneIsAlreadyTaken(String message) {
        super(message);
    }

    public PhoneIsAlreadyTaken(String message, Throwable cause) {
        super(message, cause);
    }

    public PhoneIsAlreadyTaken(Throwable cause) {
        super(cause);
    }
}
