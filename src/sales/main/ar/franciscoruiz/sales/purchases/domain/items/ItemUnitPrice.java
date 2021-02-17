package ar.franciscoruiz.sales.purchases.domain.items;

import ar.franciscoruiz.shared.domain.vo.DoubleValueObject;

public final class ItemUnitPrice extends DoubleValueObject {
    public ItemUnitPrice(Double value) {
        super(value);
    }

    private ItemUnitPrice() {
        super(null);
    }
}
