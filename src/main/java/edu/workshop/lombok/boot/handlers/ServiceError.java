package edu.workshop.lombok.boot.handlers;

import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

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

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "ServiceError{" +
                "timestamp=" + timestamp +
                ", status=" + status +
                ", message='" + message + '\'' +
                '}';
    }
}
