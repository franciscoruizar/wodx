package ar.franciscoruiz.sales.payments.infrastructure.payment_gateways;

import ar.franciscoruiz.sales.payments.domain.Payment;
import ar.franciscoruiz.sales.payments.domain.PaymentGateway;
import ar.franciscoruiz.sales.payments.domain.PaymentId;
import ar.franciscoruiz.sales.payments.domain.PaymentMount;
import ar.franciscoruiz.sales.purchases.domain.PurchaseId;

import java.time.LocalDateTime;

public final class FakerPaymentGateway implements PaymentGateway {
    @Override
    public void create(PaymentId id, PaymentMount mount, PurchaseId purchaseId, LocalDateTime dateTime) {

    }

    @Override
    public void update(PaymentId id, PaymentMount mount, PurchaseId purchaseId, LocalDateTime dateTime) {

    }

    @Override
    public void find(Payment payment) {

    }
}
