package DesignPatterns.example.DesignPatterns.strategy;

import DesignPatterns.example.DesignPatterns.dto.PaymentRequest;
import DesignPatterns.example.DesignPatterns.strategy.Impl.CreditCardPayment;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CreditCardPaymentTest {

    @Test
    public void givenCreditCardPaymentStrategy_whenPay_thenReturnsExpectedMessage() {
        PaymentRequest paymentRequest = new PaymentRequest("test-order", BigDecimal.TEN, "creditCard");
        PaymentStrategy paymentStrategy = new CreditCardPayment();
        String result = paymentStrategy.pay(paymentRequest);
        assertEquals("CreditCard Payment test-order is executed with creditCard", result);
    }
}
