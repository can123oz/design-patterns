package DesignPatterns.example.DesignPatterns.exception;

public class UnknownPaymentTypeException extends RuntimeException {
    public UnknownPaymentTypeException(String message) {
        super(message);
    }
}
