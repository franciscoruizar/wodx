package ar.franciscoruiz.accounts.purchases.domain;

import ar.franciscoruiz.shared.domain.vo.StringValueObject;

public final class PurchaseDescription extends StringValueObject {
    public PurchaseDescription(String value) {
        super(value);
    }

    public PurchaseDescription() {
        super(null);
    }
}
