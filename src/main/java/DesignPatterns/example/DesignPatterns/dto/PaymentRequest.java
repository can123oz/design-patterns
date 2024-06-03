package DesignPatterns.example.DesignPatterns.dto;

import java.math.BigDecimal;

public record PaymentRequest(String orderId, BigDecimal amount, String paymentType) {
}
