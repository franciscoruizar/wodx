package ar.franciscoruiz.sales.items.application.find_by_purchase;

import ar.franciscoruiz.shared.domain.bus.query.Query;

public final class FindByPurchaseItemQuery implements Query {
    private final String purchaseId;

    public FindByPurchaseItemQuery(String purchaseId) {
        this.purchaseId = purchaseId;
    }

    public String purchaseId() {
        return purchaseId;
    }
}
