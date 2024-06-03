package DesignPatterns.example.DesignPatterns.enumFactory.payment;

import DesignPatterns.example.DesignPatterns.dto.PaymentRequest;

public interface Payment {
    String pay(PaymentRequest paymentRequest);
}
