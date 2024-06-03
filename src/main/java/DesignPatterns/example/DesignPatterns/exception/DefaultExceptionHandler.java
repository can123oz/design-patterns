package DesignPatterns.example.DesignPatterns.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class DefaultExceptionHandler {

    private static final Logger log = LoggerFactory.getLogger(DefaultExceptionHandler.class);

    @ExceptionHandler(UnknownPaymentTypeException.class)
    public ResponseEntity<String> handleException(UnknownPaymentTypeException unknownPaymentTypeException) {
        log.error("Logging exception: ", unknownPaymentTypeException);
        return new ResponseEntity<>(unknownPaymentTypeException.getMessage(),
                HttpStatus.BAD_REQUEST);
    }
}
