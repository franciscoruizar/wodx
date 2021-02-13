package ar.franciscoruiz.sales.products.domain;

import ar.franciscoruiz.shared.domain.UuidMother;

public final class ProductIdMother {
    public static ProductId create(String value) {
        return new ProductId(value);
    }

    public static ProductId random() {
        return create(UuidMother.random());
    }
}
