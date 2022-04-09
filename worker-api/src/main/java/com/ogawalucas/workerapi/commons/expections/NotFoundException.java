package com.ogawalucas.workerapi.commons.expections;

public class NotFoundException extends RuntimeException {

    public NotFoundException(String message) {
        super(message.concat(" not found."));
    }
}
