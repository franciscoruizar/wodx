package ar.franciscoruiz.sales.purchases.domain.items;

import ar.franciscoruiz.shared.domain.UuidMother;

public final class ItemIdMother {
    public static ItemId create(String value) {
        return new ItemId(value);
    }

    public static ItemId random() {
        return create(UuidMother.random());
    }
}
