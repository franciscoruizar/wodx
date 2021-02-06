package ar.franciscoruiz.accounts.purchase_items.domain;

import ar.franciscoruiz.shared.domain.UuidMother;

public final class PurchaseItemIdMother {
    public static PurchaseItemId create(String value) {
        return new PurchaseItemId(value);
    }

    public static PurchaseItemId random() {
        return create(UuidMother.random());
    }
}
