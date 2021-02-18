package ar.franciscoruiz.sales.items.domain;

import ar.franciscoruiz.shared.domain.IntegerMother;

public final class ItemQuantityMother {
    public static ItemQuantity create(Integer value) {
        return new ItemQuantity(value);
    }

    public static ItemQuantity random() {
        return create(IntegerMother.random());
    }
}
