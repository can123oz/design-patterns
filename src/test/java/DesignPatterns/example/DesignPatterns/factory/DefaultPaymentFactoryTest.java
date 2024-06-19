package DesignPatterns.example.DesignPatterns.factory;

import DesignPatterns.example.DesignPatterns.dto.PaymentRequest;
import DesignPatterns.example.DesignPatterns.exception.UnknownPaymentTypeException;
import DesignPatterns.example.DesignPatterns.strategy.Impl.AsyncPayment;
import DesignPatterns.example.DesignPatterns.strategy.Impl.CreditCardPayment;
import DesignPatterns.example.DesignPatterns.strategy.Impl.WalletPayment;
import DesignPatterns.example.DesignPatterns.strategy.Impl.WireTransferPayment;
import DesignPatterns.example.DesignPatterns.strategy.PaymentStrategy;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class DefaultPaymentFactoryTest {

    private static Map<String, PaymentStrategy> paymentStrategyMap;
    private final DefaultPaymentFactory paymentFactory = new DefaultPaymentFactory(paymentStrategyMap);

    @BeforeAll
    public static void init() {
        paymentStrategyMap = Map.of(
                "creditCard", new CreditCardPayment(),
                "async", new AsyncPayment(),
                "wallet", new WalletPayment(),
                "wireTransfer", new WireTransferPayment()
        );
    }

    @Test
    public void givenCreditCardType_whenExecute_thenReturnsExpectedMessage() {
        PaymentRequest paymentRequest = new PaymentRequest("test-order", BigDecimal.TEN, "creditCard");

        String expected = "CreditCard Payment test-order is executed with creditCard";
        String actual = paymentFactory.execute(paymentRequest);

        assertEquals(expected, actual);
    }

    @Test
    public void testGetPaymentStrategy_ThrowsUnknownPaymentTypeException() {
        String invalidPaymentType = "invalidPaymentType";

        UnknownPaymentTypeException exception = assertThrows(
                UnknownPaymentTypeException.class,
                () -> paymentFactory.getPaymentStrategy(invalidPaymentType)
        );

        assertEquals("Invalid payment type: " + invalidPaymentType, exception.getMessage());
    }

    @Test
    public void givenPaymentRequest_whenExecute_thenReturnsExpectedMessage() {
        PaymentRequest paymentRequest = new PaymentRequest("test-order", BigDecimal.TEN, "async");
        String expected = "Async Payment test-order is executed with async";
        String actual = paymentFactory.execute(paymentRequest);
        assertEquals(expected, actual);
    }
}
