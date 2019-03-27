package edu.workshop.lombok.boot.handlers;

import lombok.Data;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Data
class ServiceError {
    private final LocalDateTime timestamp;
    private HttpStatus status;
    private String message;

    private ServiceError() {
        timestamp = LocalDateTime.now();
    }

    ServiceError(HttpStatus status) {
        this();
        this.status = status;
    }
}
