package DesignPatterns.example.DesignPatterns.factory;

import DesignPatterns.example.DesignPatterns.dto.PaymentRequest;

public interface PaymentFactory {
    String execute(PaymentRequest paymentRequest);
}
