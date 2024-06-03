package DesignPatterns.example.DesignPatterns.enumFactory;

import DesignPatterns.example.DesignPatterns.enumFactory.payment.Impl.CreditCardEnumPayment;
import DesignPatterns.example.DesignPatterns.enumFactory.payment.Impl.PaypalEnumPayment;
import DesignPatterns.example.DesignPatterns.enumFactory.payment.Impl.WalletEnumPayment;
import DesignPatterns.example.DesignPatterns.enumFactory.payment.Impl.WireTransferEnumPayment;
import DesignPatterns.example.DesignPatterns.enumFactory.payment.Payment;
import DesignPatterns.example.DesignPatterns.exception.UnknownPaymentTypeException;

public enum PaymentEnumType {
    CREDIT_CARD("creditCard", new CreditCardEnumPayment()),
    WIRE_TRANSFER("wireTransfer", new WireTransferEnumPayment()),
    WALLET("wallet", new WalletEnumPayment()),
    PAYPAL("paypal", new PaypalEnumPayment());

    private final String value;
    private final Payment payment;

    PaymentEnumType(String value, Payment payment) {
        this.value = value;
        this.payment = payment;
    }

    public String getValue() {
        return value;
    }

    public Payment getPayment() {
        return payment;
    }

    public static PaymentEnumType getPaymentType(String paymentType) {
        for (PaymentEnumType paymentEnumType : PaymentEnumType.values()) {
            if (paymentEnumType.getValue().equalsIgnoreCase(paymentType)) {
                return paymentEnumType;
            }
        }
        throw new UnknownPaymentTypeException("Invalid enum payment type: " + paymentType);
    }
}
