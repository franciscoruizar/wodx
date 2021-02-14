package ar.franciscoruiz.sales.items.application.find_by_purchase;

import ar.franciscoruiz.shared.domain.bus.query.Query;

public final class FindItemByPurchaseQuery implements Query {
    private final String purchaseId;

    public FindItemByPurchaseQuery(String purchaseId) {
        this.purchaseId = purchaseId;
    }

    public String purchaseId() {
        return purchaseId;
    }
}
