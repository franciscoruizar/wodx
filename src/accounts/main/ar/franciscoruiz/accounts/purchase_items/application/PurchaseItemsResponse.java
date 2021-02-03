package ar.franciscoruiz.accounts.purchase_items.application;

import ar.franciscoruiz.shared.domain.bus.query.Response;

import java.util.List;

public final class PurchaseItemsResponse implements Response {
    private final List<PurchaseItemResponse> items;

    public PurchaseItemsResponse(List<PurchaseItemResponse> items) {
        this.items = items;
    }

    public List<PurchaseItemResponse> items() {
        return this.items;
    }
}
