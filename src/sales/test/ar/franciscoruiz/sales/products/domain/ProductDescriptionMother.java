package ar.franciscoruiz.sales.products.domain;

import ar.franciscoruiz.shared.domain.WordMother;

public final class ProductDescriptionMother {
    public static ProductDescription create(String value) {
        return new ProductDescription(value);
    }

    public static ProductDescription random() {
        return create(WordMother.random());
    }
}
