package com.inversiones.cartera.infrastructure.controllers.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record ErrorResponse(
    int status,
    String error,
    String message,
    String path,
    LocalDateTime timestamp,
    Map<String, List<String>> validationErrors
) {
    public static ErrorResponse of(int status, String error, String message, String path) {
        return new ErrorResponse(status, error, message, path, LocalDateTime.now(), null);
    }

    public static ErrorResponse of(int status, String error, String message, String path, 
                                    Map<String, List<String>> validationErrors) {
        return new ErrorResponse(status, error, message, path, LocalDateTime.now(), validationErrors);
    }

    public static ErrorResponse notFound(String message, String path) {
        return of(404, "Not Found", message, path);
    }

    public static ErrorResponse badRequest(String message, String path) {
        return of(400, "Bad Request", message, path);
    }

    public static ErrorResponse internalError(String message, String path) {
        return of(500, "Internal Server Error", message, path);
    }

    public static ErrorResponse conflict(String message, String path) {
        return of(409, "Conflict", message, path);
    }

    public static ErrorResponse validationError(String message, String path, 
                                                 Map<String, List<String>> validationErrors) {
        return of(400, "Validation Error", message, path, validationErrors);
    }
}