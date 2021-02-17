package ar.franciscoruiz.sales.payments.application.create;

import ar.franciscoruiz.sales.payments.domain.*;
import ar.franciscoruiz.sales.payments.infrastructure.payment_gateways.PaymentGatewayFactory;
import ar.franciscoruiz.sales.purchases.domain.PurchaseId;
import ar.franciscoruiz.shared.domain.Service;

import java.time.LocalDateTime;

@Service
public final class PaymentCreator {
    private final PaymentRepository repository;

    public PaymentCreator(PaymentRepository repository) {
        this.repository = repository;
    }

    public void create(
        PaymentId id,
        PaymentMethod method,
        PaymentMount mount,
        PurchaseId purchaseId,
        LocalDateTime dateTime
    ) {
        try {
            PaymentGateway paymentGateway = new PaymentGatewayFactory().instance(method);

            paymentGateway.create(id, mount, purchaseId, dateTime);

            Payment payment = new Payment(id, method, mount, purchaseId, new PaymentStatus(true), dateTime);

            this.repository.save(payment);
        } catch (GatewayPaymentError error) {
            Payment payment = new Payment(id, method, mount, purchaseId, new PaymentStatus(false), dateTime);

            this.repository.save(payment);
        }
    }
}
