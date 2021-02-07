package ar.franciscoruiz.accounts.items.domain;

import ar.franciscoruiz.shared.domain.MotherCreator;

public final class ItemQuantityMother {
    public static ItemQuantity create(Integer value) {
        return new ItemQuantity(value);
    }

    public static ItemQuantity random() {
        return create(MotherCreator.random().number().randomDigitNotZero());
    }
}
