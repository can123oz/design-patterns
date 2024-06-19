package DesignPatterns.example.DesignPatterns.controller;

import DesignPatterns.example.DesignPatterns.dto.PaymentRequest;
import DesignPatterns.example.DesignPatterns.enumFactory.PaymentEnumType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v2/payment")
public class PaymentEnumController {
    @PostMapping
    public ResponseEntity<String> pay(@RequestBody PaymentRequest paymentRequest) {
        String result = PaymentEnumType.getPaymentType(paymentRequest.paymentType())
                .getPayment()
                .pay(paymentRequest);
        return ResponseEntity.ok(result);
    }
}
