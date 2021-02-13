package ar.franciscoruiz.sales.purchases.domain;

import ar.franciscoruiz.shared.domain.vo.StringValueObject;

public final class PurchaseDescription extends StringValueObject {
    public PurchaseDescription(String value) {
        super(value);
    }

    private PurchaseDescription() {
        super(null);
    }
}
