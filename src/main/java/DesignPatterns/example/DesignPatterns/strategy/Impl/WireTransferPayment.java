package DesignPatterns.example.DesignPatterns.strategy.Impl;

import DesignPatterns.example.DesignPatterns.dto.PaymentRequest;
import DesignPatterns.example.DesignPatterns.strategy.PaymentStrategy;
import org.springframework.stereotype.Service;

@Service("wireTransfer")
public class WireTransferPayment implements PaymentStrategy {
    @Override
    public String pay(PaymentRequest paymentRequest) {
        return "Wire Transfer Payment " + paymentRequest.orderId() + " is executed with "
                + paymentRequest.paymentType();
    }
}
