package ar.franciscoruiz.accounts.purchases.application.calculator;

import ar.franciscoruiz.accounts.purchase_items.application.PurchaseItemResponse;
import ar.franciscoruiz.accounts.purchase_items.application.PurchaseItemsResponse;

public final class TotalPriceCalculator {
    private final PurchaseItemsResponse items;

    public TotalPriceCalculator(PurchaseItemsResponse items) {
        this.items = items;
    }

    public double calculate() {
        return items.items().stream().mapToDouble(PurchaseItemResponse::price).sum();
    }
}
