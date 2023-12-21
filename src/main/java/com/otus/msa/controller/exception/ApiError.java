package com.otus.msa.controller.exception;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class ApiError extends RuntimeException {
    private Class<?> type;
    private HttpStatus status;
    private String message;
    private Exception cause;

    public static ApiError notFound(Class<?> type, Object id, Exception cause) {
        String msg = buildMessage(type, id, " is not found");
        return new ApiError(type, HttpStatus.NOT_FOUND, msg, cause);
    }

    public static ApiError alreadyPresent(Class<?> type, Object id, Exception cause) {
        String msg = buildMessage(type, id, " is already present in DB");
        return new ApiError(type, HttpStatus.BAD_REQUEST, msg, cause);
    }

    public static ApiError badRequest(Class<?> type, Object id, String message) {
        String msg = buildMessage(type, id, " " + message);
        return new ApiError(type, HttpStatus.BAD_REQUEST, msg, null);
    }

    private static String buildMessage(Class type, Object id, String msg) {
        return type.getSimpleName() + " entity with id: " + id + ". " + msg;
    }

    public static ApiError internalServerError(String message, Exception cause) {
        return new ApiError(null, HttpStatus.INTERNAL_SERVER_ERROR, message, cause);
    }
}

