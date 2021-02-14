package ar.franciscoruiz.sales.account_statements.application;

import ar.franciscoruiz.sales.items.application.ItemsResponse;
import ar.franciscoruiz.sales.purchases.application.PurchaseResponse;
import ar.franciscoruiz.shared.domain.bus.query.Response;

import java.util.HashMap;

public final class AccountStatementResponse implements Response {
    private final PurchaseResponse lastPurchase;
    private final ItemsResponse    items;
    private final Boolean          isActive;

    public AccountStatementResponse(PurchaseResponse lastPurchase, ItemsResponse items, Boolean isActive) {
        this.lastPurchase = lastPurchase;
        this.items        = items;
        this.isActive     = isActive;
    }

    public HashMap<String, Object> toPrimitives() {
        HashMap<String, Object> response = new HashMap<>();

        response.put("last_purchase", this.lastPurchase.toPrimitives());
        response.put("items", this.items.toPrimitives());
        response.put("is_active", this.isActive);

        return response;
    }

    public Boolean isActive() {
        return isActive;
    }

    public PurchaseResponse lastPurchase() {
        return lastPurchase;
    }

    public ItemsResponse items() {
        return items;
    }
}
