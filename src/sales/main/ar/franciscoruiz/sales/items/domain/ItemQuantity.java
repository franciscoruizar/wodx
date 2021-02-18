package ar.franciscoruiz.sales.items.domain;

import ar.franciscoruiz.shared.domain.vo.IntValueObject;

public final class ItemQuantity extends IntValueObject {
    public ItemQuantity(Integer value) {
        super(value);
    }

    private ItemQuantity() {
        super(null);
    }
}
