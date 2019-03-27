package edu.workshop.lombok.boot.handlers;

import edu.workshop.lombok.boot.exceptions.DuplicateEntryException;
import edu.workshop.lombok.boot.exceptions.NotFoundException;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(DuplicateEntryException.class)
    protected ResponseEntity<Object> handleDuplicateEntry(DuplicateEntryException exception) {
        ServiceError error = new ServiceError(HttpStatus.CONFLICT);
        error.setMessage(exception.getMessage());
        return buildResponseEntity(error);
    }

    @ExceptionHandler(NotFoundException.class)
    protected ResponseEntity<Object> handleEntityNotFound(NotFoundException exception) {
        ServiceError error = new ServiceError(HttpStatus.NOT_FOUND);
        error.setMessage(exception.getMessage());
        return buildResponseEntity(error);
    }

    private ResponseEntity<Object> buildResponseEntity(ServiceError error) {
        return new ResponseEntity<>(error, error.getStatus());
    }
}