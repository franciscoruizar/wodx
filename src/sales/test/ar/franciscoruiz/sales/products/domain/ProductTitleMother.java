package ar.franciscoruiz.sales.products.domain;

import ar.franciscoruiz.shared.domain.WordMother;

public final class ProductTitleMother {
    public static ProductTitle create(String value) {
        return new ProductTitle(value);
    }

    public static ProductTitle random() {
        return create(WordMother.random());
    }
}
