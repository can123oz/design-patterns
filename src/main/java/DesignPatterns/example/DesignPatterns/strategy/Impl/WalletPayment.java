package DesignPatterns.example.DesignPatterns.strategy.Impl;

import DesignPatterns.example.DesignPatterns.dto.PaymentRequest;
import DesignPatterns.example.DesignPatterns.strategy.PaymentStrategy;
import org.springframework.stereotype.Service;

@Service("wallet")
public class WalletPayment implements PaymentStrategy {
    @Override
    public String pay(PaymentRequest paymentRequest) {
        return "Wallet Payment " + paymentRequest.orderId() + " is executed with "
                + paymentRequest.paymentType();
    }
}
