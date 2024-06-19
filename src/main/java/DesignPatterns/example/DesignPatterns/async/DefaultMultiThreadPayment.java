package DesignPatterns.example.DesignPatterns.async;

import DesignPatterns.example.DesignPatterns.dto.PaymentRequest;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
public class DefaultMultiThreadPayment implements MultiThreadPayment {

    @Override
    @Async
    public CompletableFuture<String> pay(PaymentRequest paymentRequest) {
        try {
            Thread.sleep(6 * 1000L);
            return CompletableFuture.completedFuture("Default Async Payment " + paymentRequest.orderId());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    @EventListener
    public void payEventSync(PaymentEvent event) {
        System.out.println("Payment Event Triggered : " + event.orderId());
    }


    @Override
    @EventListener
    @Async
    public void payEventAsync(PaymentEvent event) {
        // TODO
        /*
        try {
            Thread.sleep(6 * 1000L);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Payment Async Event Triggered : " + event.orderId());
         */
    }
}
