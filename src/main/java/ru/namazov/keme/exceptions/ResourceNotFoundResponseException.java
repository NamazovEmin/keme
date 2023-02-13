package ru.namazov.keme.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class ResourceNotFoundResponseException extends ResponseStatusException {

    public ResourceNotFoundResponseException(String reason) {
        super(HttpStatus.NOT_FOUND, reason);
    }
}

