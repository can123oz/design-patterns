package DesignPatterns.example.DesignPatterns.enumFactory.payment.Impl;

import DesignPatterns.example.DesignPatterns.dto.PaymentRequest;
import DesignPatterns.example.DesignPatterns.enumFactory.payment.Payment;
import org.springframework.stereotype.Service;

@Service
public class WireTransferEnumPayment implements Payment {
    @Override
    public String pay(PaymentRequest paymentRequest) {
        return "Wire Transfer with Enum Type : " + paymentRequest.orderId();
    }
}
