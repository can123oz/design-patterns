package DesignPatterns.example.DesignPatterns.controller;

import DesignPatterns.example.DesignPatterns.dto.PaymentRequest;
import DesignPatterns.example.DesignPatterns.factory.PaymentFactory;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/payment")
public class PaymentController {

    private final PaymentFactory paymentFactory;

    public PaymentController(PaymentFactory paymentFactory) {
        this.paymentFactory = paymentFactory;
    }

    @Operation(summary = "Basic payment creation endpoint.", description = "we can change the payment type behavior by " +
            "giving the payment type credit or wallet.")
    @PostMapping
    public ResponseEntity<String> pay(@RequestBody PaymentRequest paymentRequest) {
        return ResponseEntity.ok(paymentFactory.execute(paymentRequest));
    }
}
