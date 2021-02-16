package ar.franciscoruiz.sales.purchases.domain.items;

import ar.franciscoruiz.shared.domain.vo.IntValueObject;

public final class ItemQuantity extends IntValueObject {
    public ItemQuantity(Integer value) {
        super(value);
    }

    public ItemQuantity() {
        super(null);
    }
}
