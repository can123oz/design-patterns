package DesignPatterns.example.DesignPatterns.factory;

import DesignPatterns.example.DesignPatterns.dto.PaymentRequest;

public interface PaymentFactory {
    public String execute(PaymentRequest paymentRequest);
}
