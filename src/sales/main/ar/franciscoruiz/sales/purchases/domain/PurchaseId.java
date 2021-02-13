package ar.franciscoruiz.sales.purchases.domain;

import ar.franciscoruiz.shared.domain.Identifier;

public final class PurchaseId extends Identifier {
    public PurchaseId(String value) {
        super(value);
    }

    private PurchaseId() {
    }
}
