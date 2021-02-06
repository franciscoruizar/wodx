package ar.franciscoruiz.accounts.purchases.domain;

import ar.franciscoruiz.shared.domain.WordMother;

public final class PurchaseDescriptionMother {
    public static PurchaseDescription create(String value) {
        return new PurchaseDescription(value);
    }

    public static PurchaseDescription random() {
        return create(WordMother.random());
    }
}
