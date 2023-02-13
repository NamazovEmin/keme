package ru.namazov.keme.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class ResourceAlreadyExistsResponseException extends ResponseStatusException {

    public ResourceAlreadyExistsResponseException(String reason) {
        super(HttpStatus.PRECONDITION_FAILED, reason);
    }
}

