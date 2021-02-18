package ar.franciscoruiz.sales.payments.domain;

import ar.franciscoruiz.sales.purchases.domain.PurchaseId;

import java.time.LocalDateTime;

public interface PaymentGateway {
    void create(PaymentId id, PaymentMount mount, PurchaseId purchaseId, LocalDateTime dateTime) throws GatewayPaymentError;

    void update(PaymentId id, PaymentMount mount, PurchaseId purchaseId, LocalDateTime dateTime) throws GatewayPaymentError;

    void find(Payment payment);
}
