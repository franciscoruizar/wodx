package ar.franciscoruiz.sales.payments.application.search_by_purchase;

import ar.franciscoruiz.sales.payments.application.PaymentResponse;
import ar.franciscoruiz.sales.payments.application.PaymentsResponse;
import ar.franciscoruiz.sales.payments.domain.PaymentRepository;
import ar.franciscoruiz.sales.purchases.domain.PurchaseId;
import ar.franciscoruiz.shared.domain.Service;

import java.util.stream.Collectors;

@Service
public final class PaymentsByPurchaseSearcher {
    private final PaymentRepository repository;

    public PaymentsByPurchaseSearcher(PaymentRepository repository) {
        this.repository = repository;
    }

    public PaymentsResponse search(PurchaseId purchaseId) {
        return new PaymentsResponse(
            this.repository.searchByPurchase(purchaseId)
                .stream()
                .map(PaymentResponse::fromAggregate)
                .collect(Collectors.toList())
        );
    }
}
