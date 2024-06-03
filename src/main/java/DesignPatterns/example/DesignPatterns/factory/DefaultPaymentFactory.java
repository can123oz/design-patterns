package DesignPatterns.example.DesignPatterns.factory;

import DesignPatterns.example.DesignPatterns.dto.PaymentRequest;
import DesignPatterns.example.DesignPatterns.exception.UnknownPaymentTypeException;
import DesignPatterns.example.DesignPatterns.strategy.PaymentStrategy;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class DefaultPaymentFactory implements PaymentFactory {

    private final Map<String, PaymentStrategy> paymentStrategyMap;

    public DefaultPaymentFactory(Map<String, PaymentStrategy> paymentStrategyMap) {
        this.paymentStrategyMap = paymentStrategyMap;
    }

    public PaymentStrategy getPaymentStrategy(String paymentType) {
        PaymentStrategy paymentStrategy = paymentStrategyMap.get(paymentType);
        if (paymentStrategy == null) {
            throw new UnknownPaymentTypeException("Invalid payment type: " + paymentType);
        }
        return paymentStrategy;
    }

    @Override
    public String execute(PaymentRequest paymentRequest) {
        PaymentStrategy paymentStrategy = getPaymentStrategy(paymentRequest.paymentType());
        return paymentStrategy.pay(paymentRequest);
    }
}
