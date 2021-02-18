package ar.franciscoruiz.shared.infrastructure.spring;

import ar.franciscoruiz.shared.domain.DomainError;
import io.jsonwebtoken.ExpiredJwtException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

@ControllerAdvice
public class ApiExceptionMiddleware extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = {Exception.class})
    public ResponseEntity<Object> handleAnyException(Exception ex, WebRequest request) {

        String errorMessageDescription = ex.getLocalizedMessage();

        if (errorMessageDescription == null) errorMessageDescription = ex.toString();

        ErrorMessage errorMessage = new ErrorMessage(new Date(), errorMessageDescription);

        return new ResponseEntity<>
            (
                errorMessage,
                new HttpHeaders(),
                HttpStatus.INTERNAL_SERVER_ERROR
            );
    }

    @ExceptionHandler(value = {ExpiredJwtException.class})
    public ResponseEntity<Object> handleAnyException(ExpiredJwtException ex, WebRequest request) {

        String errorMessageDescription = ex.getLocalizedMessage();

        if (errorMessageDescription == null) errorMessageDescription = ex.toString();

        ErrorMessage errorMessage = new ErrorMessage(new Date(), errorMessageDescription);

        return new ResponseEntity<>
            (
                errorMessage,
                new HttpHeaders(),
                HttpStatus.INTERNAL_SERVER_ERROR
            );
    }

    @ExceptionHandler(value = {NullPointerException.class})
    public ResponseEntity<Object> handleSpecificExceptions(NullPointerException ex, WebRequest request) {

        String errorMessageDescription = ex.getLocalizedMessage();

        if (errorMessageDescription == null) errorMessageDescription = ex.toString();

        ErrorMessage errorMessage = new ErrorMessage(new Date(), errorMessageDescription);

        return new ResponseEntity<>(
            errorMessage, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);

    }

    @ExceptionHandler(value = {DomainError.class, RuntimeException.class})
    public ResponseEntity<Object> handleNotExistsExceptions(DomainError ex, WebRequest request) {

        String errorMessageDescription = ex.getLocalizedMessage();

        if (errorMessageDescription == null) errorMessageDescription = ex.toString();

        ErrorMessage errorMessage = new ErrorMessage(new Date(), errorMessageDescription);

        return new ResponseEntity<>(errorMessage, new HttpHeaders(), HttpStatus.NOT_FOUND);
    }
}
