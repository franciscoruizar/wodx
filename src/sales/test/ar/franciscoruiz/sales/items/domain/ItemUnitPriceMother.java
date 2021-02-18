package ar.franciscoruiz.sales.items.domain;

import ar.franciscoruiz.shared.domain.DoubleMother;

public final class ItemUnitPriceMother {
    public static ItemUnitPrice create(Double value) {
        return new ItemUnitPrice(value);
    }

    public static ItemUnitPrice random() {
        return create(DoubleMother.random());
    }
}
