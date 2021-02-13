package ar.franciscoruiz.sales.products.domain;

import ar.franciscoruiz.shared.domain.BooleanMother;

public final class ProductIsActiveMother {
    public static ProductIsActive create(Boolean value) {
        return new ProductIsActive(value);
    }

    public static ProductIsActive random() {
        return create(BooleanMother.random());
    }
}
