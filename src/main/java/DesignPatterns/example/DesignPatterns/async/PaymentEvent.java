package DesignPatterns.example.DesignPatterns.async;

import java.math.BigDecimal;

public record PaymentEvent(String orderId, BigDecimal amount) {
}
