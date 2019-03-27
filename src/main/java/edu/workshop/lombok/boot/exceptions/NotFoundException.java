package edu.workshop.lombok.boot.exceptions;

public class NotFoundException extends RuntimeException {

    public NotFoundException(Class<?> entityClass, String key) {
        super(String.format("Entity not found for class %s and key %s", entityClass.getSimpleName(), key));
    }
}
