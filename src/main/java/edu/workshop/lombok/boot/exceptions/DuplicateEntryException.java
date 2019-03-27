package edu.workshop.lombok.boot.exceptions;

public class DuplicateEntryException extends RuntimeException {

    public DuplicateEntryException(Class<?> entityClass, String identifier) {
        super(String.format("Entity of type %s already exists with key: %s.", entityClass.getSimpleName(), identifier));
    }
}
