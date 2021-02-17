package ar.franciscoruiz.sales.payments.domain;

import ar.franciscoruiz.sales.purchases.domain.PurchaseId;

import java.util.List;
import java.util.Optional;

public interface PaymentRepository {
    void save(Payment payment);

    Optional<Payment> search(PaymentId id);

    List<Payment> searchByPurchase(PurchaseId id);
}
