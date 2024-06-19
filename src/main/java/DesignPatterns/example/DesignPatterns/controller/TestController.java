package DesignPatterns.example.DesignPatterns.controller;

import DesignPatterns.example.DesignPatterns.async.MultiThreadPayment;
import DesignPatterns.example.DesignPatterns.async.PaymentEvent;
import DesignPatterns.example.DesignPatterns.dto.PaymentRequest;
import DesignPatterns.example.DesignPatterns.factory.PaymentFactory;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/api/v1/test")
public class TestController {

    private final ApplicationEventPublisher applicationEventPublisher;
    private final PaymentFactory paymentFactory;
    private final MultiThreadPayment multiThreadPayment;

    public TestController(ApplicationEventPublisher applicationEventPublisher,
                          PaymentFactory paymentFactory,
                          MultiThreadPayment multiThreadPayment) {
        this.applicationEventPublisher = applicationEventPublisher;
        this.paymentFactory = paymentFactory;
        this.multiThreadPayment = multiThreadPayment;
    }

    @GetMapping(value = "/completableFuture")
    public ResponseEntity<String> completableFuture() {
        PaymentRequest paymentRequest = new PaymentRequest("test-order", BigDecimal.TEN, "async");
        // For Java 17 version
        CompletableFuture.runAsync(() -> {
            String paymentResult = paymentFactory.execute(paymentRequest);
            System.out.println(paymentResult);
        });
        /*
        // For Java 21+ versions
        Thread.ofVirtual().start(() -> {
            String paymentResult = paymentFactory.execute(paymentRequest);
            System.out.println(paymentResult);
        });
         */
        return ResponseEntity.ok("Hello Completable Future World");
    }

    @GetMapping(value = "/async")
    public ResponseEntity<String> async() {
        PaymentRequest paymentRequest = new PaymentRequest("test-async-order", BigDecimal.TEN, "async");
        try {
            CompletableFuture<String> paymentResult = multiThreadPayment.pay(paymentRequest);
            paymentResult.thenApply(result -> result).thenAccept(System.out::println);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return ResponseEntity.ok("Hello @Async World");
    }

    @GetMapping(value = "/sync-event")
    public ResponseEntity<String> syncEvent() {
        PaymentEvent event = new PaymentEvent("test-event-order", BigDecimal.TEN);
        applicationEventPublisher.publishEvent(event);
        return ResponseEntity.ok("Hello @EventListener World");
    }

}
