package com.inventnow.projectx.exception;

import com.inventnow.projectx.user.exception.UserAlreadyRegisteredException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ErrorResponse> handleNotFoundException(NotFoundException notFoundException) {
        return new ResponseEntity<>(new ErrorResponse("NOT_FOUND", notFoundException.getMessage()),
                HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleGenericException(Exception notFoundException) {
        return new ResponseEntity<>(new ErrorResponse("GENERIC_ERROR", notFoundException.getMessage()),
                HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(UserAlreadyRegisteredException.class)
    public ResponseEntity<ErrorResponse> handleDataAlreadyExist(UserAlreadyRegisteredException conflictException) {
        return new ResponseEntity<>(new ErrorResponse("CONFLICT", conflictException.getMessage()),
                HttpStatus.CONFLICT);
    }

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<ErrorResponse> handleBadRequest(BadRequestException badRequestException) {
        return new ResponseEntity<>(new ErrorResponse("BAD_REQUEST", badRequestException.getMessage()),
                HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler({AccessDeniedException.class})
    public ResponseEntity<Object> handleAccessDeniedException(
            Exception ex, WebRequest request) {
        return new ResponseEntity<Object>(
                "Access denied message here", new HttpHeaders(), HttpStatus.FORBIDDEN);
    }
}
