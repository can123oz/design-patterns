package DesignPatterns.example.DesignPatterns.enumFactory;

import DesignPatterns.example.DesignPatterns.exception.UnknownPaymentTypeException;

public enum PaymentEnumType {
    CREDIT_CARD("creditCard"),
    WIRE_TRANSFER("wireTransfer"),
    WALLET("wallet"),
    PAYPAL("paypal");

    private final String value;

    PaymentEnumType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static PaymentEnumType getPaymentType(String paymentType) {
        for (PaymentEnumType paymentEnumType : PaymentEnumType.values()) {
            if (paymentEnumType.getValue().equalsIgnoreCase(paymentType)) {
                return paymentEnumType;
            }
        }
        throw new UnknownPaymentTypeException("Invalid payment type: " + paymentType);
    }
}
