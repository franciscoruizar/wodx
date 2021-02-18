package ar.franciscoruiz.sales.payments.domain.services.search_by_purchase;

import ar.franciscoruiz.sales.payments.domain.Payment;
import ar.franciscoruiz.sales.payments.domain.PaymentRepository;
import ar.franciscoruiz.sales.purchases.domain.PurchaseId;
import ar.franciscoruiz.shared.domain.Service;

import java.util.List;

@Service
public final class PaymentsByPurchaseDomainSearcher {
    private final PaymentRepository repository;

    public PaymentsByPurchaseDomainSearcher(PaymentRepository repository) {
        this.repository = repository;
    }

    public List<Payment> search(PurchaseId purchaseId) {
        return this.repository.searchByPurchase(purchaseId);
    }
}
