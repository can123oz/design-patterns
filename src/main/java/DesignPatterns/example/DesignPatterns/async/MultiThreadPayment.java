package DesignPatterns.example.DesignPatterns.async;

import DesignPatterns.example.DesignPatterns.dto.PaymentRequest;

import java.util.concurrent.CompletableFuture;

public interface MultiThreadPayment {
    CompletableFuture<String> pay(PaymentRequest paymentRequest);

    void payEventSync(PaymentEvent event);

    void payEventAsync(PaymentEvent event);
}
