package ru.testwork.notebook.exceptions;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ErrorHandler {
    @ExceptionHandler
    public ErrorResponse handleObjectNotExistError(final NotFoundException e) {
        return new ErrorResponse(e.getMessage());
    }

    @ExceptionHandler
    public ErrorResponse handleObjectValidationError(final ValidationException e) {
        return new ErrorResponse(e.getMessage());
    }
}
