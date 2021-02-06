package ar.franciscoruiz.accounts.purchase_items.domain;

import ar.franciscoruiz.shared.domain.MotherCreator;

public final class PurchaseItemQuantityMother {
    public static PurchaseItemQuantity create(Integer value) {
        return new PurchaseItemQuantity(value);
    }

    public static PurchaseItemQuantity random() {
        return create(MotherCreator.random().number().randomDigitNotZero());
    }
}
