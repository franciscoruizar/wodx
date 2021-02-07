package ar.franciscoruiz.accounts.purchases.application;

import ar.franciscoruiz.shared.domain.bus.query.Response;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public final class PurchasesResponse implements Response {
    private final List<PurchaseResponse> values;

    public PurchasesResponse(List<PurchaseResponse> values) {
        this.values = values;
    }

    public List<PurchaseResponse> values() {
        return this.values;
    }

    public List<HashMap<String, Object>> toPrimitives() {
        return this.values
            .stream()
            .map(PurchaseResponse::toPrimitives)
            .collect(Collectors.toList());
    }
}
