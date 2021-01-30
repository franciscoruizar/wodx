package ar.franciscoruiz.accounts.purchases.application;

import ar.franciscoruiz.shared.domain.bus.query.Response;

import java.util.List;

public final class PurchasesResponse implements Response {
    private final List<PurchaseResponse> values;

    public PurchasesResponse(List<PurchaseResponse> values) {
        this.values = values;
    }

    public List<PurchaseResponse> values() {
        return this.values;
    }
}
