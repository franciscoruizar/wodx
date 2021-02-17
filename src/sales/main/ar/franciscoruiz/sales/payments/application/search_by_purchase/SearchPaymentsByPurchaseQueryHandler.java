package ar.franciscoruiz.sales.payments.application.search_by_purchase;

import ar.franciscoruiz.sales.payments.application.PaymentsResponse;
import ar.franciscoruiz.sales.purchases.domain.PurchaseId;
import ar.franciscoruiz.shared.domain.Service;
import ar.franciscoruiz.shared.domain.bus.query.QueryHandler;

@Service
public final class SearchPaymentsByPurchaseQueryHandler implements QueryHandler<SearchPaymentsByPurchaseQuery, PaymentsResponse> {
    private final PaymentsByPurchaseSearcher searcher;

    public SearchPaymentsByPurchaseQueryHandler(PaymentsByPurchaseSearcher searcher) {
        this.searcher = searcher;
    }

    @Override
    public PaymentsResponse handle(SearchPaymentsByPurchaseQuery query) {
        PurchaseId purchaseId = new PurchaseId(query.purchaseId());

        return this.searcher.search(purchaseId);
    }
}
