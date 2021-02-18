package ar.franciscoruiz.sales.payments.application.search_by_purchase;

import ar.franciscoruiz.sales.payments.application.PaymentResponse;
import ar.franciscoruiz.sales.payments.application.PaymentsResponse;
import ar.franciscoruiz.sales.payments.domain.PaymentRepository;
import ar.franciscoruiz.sales.payments.domain.services.search_by_purchase.PaymentsByPurchaseDomainSearcher;
import ar.franciscoruiz.sales.purchases.domain.PurchaseId;
import ar.franciscoruiz.shared.domain.Service;

import java.util.stream.Collectors;

@Service
public final class PaymentsByPurchaseSearcher {
    private final PaymentsByPurchaseDomainSearcher searcher;

    public PaymentsByPurchaseSearcher(PaymentRepository repository) {
        this.searcher = new PaymentsByPurchaseDomainSearcher(repository);
    }

    public PaymentsResponse search(PurchaseId purchaseId) {
        return new PaymentsResponse(
            this.searcher.search(purchaseId)
                .stream()
                .map(PaymentResponse::fromAggregate)
                .collect(Collectors.toList())
        );
    }
}
