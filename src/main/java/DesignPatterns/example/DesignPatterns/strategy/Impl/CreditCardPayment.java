package DesignPatterns.example.DesignPatterns.strategy.Impl;

import DesignPatterns.example.DesignPatterns.dto.PaymentRequest;
import DesignPatterns.example.DesignPatterns.strategy.PaymentStrategy;
import org.springframework.stereotype.Service;

@Service("creditCard")
public class CreditCardPayment implements PaymentStrategy {
    @Override
    public String pay(PaymentRequest paymentRequest) {
        return "CreditCard Payment " + paymentRequest.orderId() + " is executed with "
                + paymentRequest.paymentType();
    }
}
