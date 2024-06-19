package DesignPatterns.example.DesignPatterns.strategy.Impl;

import DesignPatterns.example.DesignPatterns.dto.PaymentRequest;
import DesignPatterns.example.DesignPatterns.strategy.PaymentStrategy;
import org.springframework.stereotype.Service;

@Service("async")
public class AsyncPayment implements PaymentStrategy {

    @Override
    public String pay(PaymentRequest paymentRequest) {
        try {
            Thread.sleep(6 * 1000L);
            return "Async Payment " + paymentRequest.orderId() + " is executed with "
                    + paymentRequest.paymentType();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
