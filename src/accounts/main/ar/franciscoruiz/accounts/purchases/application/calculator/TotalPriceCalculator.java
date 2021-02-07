package ar.franciscoruiz.accounts.purchases.application.calculator;

import ar.franciscoruiz.accounts.items.application.ItemResponse;
import ar.franciscoruiz.accounts.items.application.ItemsResponse;

public final class TotalPriceCalculator {
    private final ItemsResponse items;

    public TotalPriceCalculator(ItemsResponse items) {
        this.items = items;
    }

    public double calculate() {
        return items.values().stream().mapToDouble(ItemResponse::price).sum();
    }
}
