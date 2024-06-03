package DesignPatterns.example.DesignPatterns.enumFactory.payment.Impl;

import DesignPatterns.example.DesignPatterns.dto.PaymentRequest;
import DesignPatterns.example.DesignPatterns.enumFactory.payment.Payment;
import org.springframework.stereotype.Service;

@Service
public class WireTransferPayment implements Payment {
    @Override
    public String pay(PaymentRequest paymentRequest) {
        return "Wallet Payment with Enum Type : " + paymentRequest.orderId();
    }
}
