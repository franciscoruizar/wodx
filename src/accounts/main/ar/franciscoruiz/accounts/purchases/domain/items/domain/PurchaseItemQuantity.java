package ar.franciscoruiz.accounts.purchases.domain.items.domain;

import ar.franciscoruiz.shared.domain.vo.IntValueObject;

public final class PurchaseItemQuantity extends IntValueObject {
    public PurchaseItemQuantity(Integer value) {
        super(value);
    }

    public PurchaseItemQuantity() {
        super(null);
    }
}
