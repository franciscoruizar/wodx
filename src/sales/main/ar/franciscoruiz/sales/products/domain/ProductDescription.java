package ar.franciscoruiz.sales.products.domain;

import ar.franciscoruiz.shared.domain.vo.StringValueObject;

public final class ProductDescription extends StringValueObject {
    public ProductDescription(String value) {
        super(value);
    }

    private ProductDescription() {
        super(null);
    }
}
