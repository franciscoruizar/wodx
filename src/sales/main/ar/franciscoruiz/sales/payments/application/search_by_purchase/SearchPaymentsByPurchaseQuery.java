package ar.franciscoruiz.sales.payments.application.search_by_purchase;

import ar.franciscoruiz.shared.domain.bus.query.Query;

public final class SearchPaymentsByPurchaseQuery implements Query {
    private final String purchaseId;

    public SearchPaymentsByPurchaseQuery(String purchaseId) {
        this.purchaseId = purchaseId;
    }

    public String purchaseId() {
        return purchaseId;
    }
}
