package DesignPatterns.example.DesignPatterns.strategy;

import DesignPatterns.example.DesignPatterns.dto.PaymentRequest;

public interface PaymentStrategy {
    String pay(PaymentRequest paymentRequest);
}
