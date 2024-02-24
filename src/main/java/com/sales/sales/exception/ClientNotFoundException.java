package com.sales.sales.exception;

public class ClientNotFoundException extends RuntimeException {

    private final String description;

    public ClientNotFoundException(String message) {
        super(message);
        this.description = null;
    }
}
