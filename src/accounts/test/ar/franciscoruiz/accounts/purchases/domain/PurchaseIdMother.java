package ar.franciscoruiz.accounts.purchases.domain;

import ar.franciscoruiz.shared.domain.UuidMother;

public final class PurchaseIdMother {
    public static PurchaseId create(String value) {
        return new PurchaseId(value);
    }

    public static PurchaseId random() {
        return create(UuidMother.random());
    }
}
