package ar.franciscoruiz.sales.purchases.application.account_statement;

import ar.franciscoruiz.sales.purchases.application.PurchaseResponse;
import ar.franciscoruiz.shared.domain.bus.query.Response;

import java.util.HashMap;

public final class AccountStatementResponse implements Response {
    private final PurchaseResponse lastPurchase;
    private final Boolean          isActive;

    public AccountStatementResponse(PurchaseResponse lastPurchase, Boolean isActive) {
        this.lastPurchase = lastPurchase;
        this.isActive     = isActive;
    }

    public HashMap<String, Object> toPrimitives() {
        HashMap<String, Object> response = new HashMap<>();

        response.put("last_purchase", this.lastPurchase.toPrimitives());
        response.put("is_active", this.isActive);

        return response;
    }

    public Boolean isActive() {
        return isActive;
    }

    public PurchaseResponse lastPurchase() {
        return lastPurchase;
    }
}
