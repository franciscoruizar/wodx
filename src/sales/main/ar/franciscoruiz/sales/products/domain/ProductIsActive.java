package ar.franciscoruiz.sales.products.domain;

import ar.franciscoruiz.shared.domain.vo.BooleanValueObject;

public final class ProductIsActive extends BooleanValueObject {
    public ProductIsActive(Boolean value) {
        super(value);
    }

    public ProductIsActive() {
        super(null);
    }
}
