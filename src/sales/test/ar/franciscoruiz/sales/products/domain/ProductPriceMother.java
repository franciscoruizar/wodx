package ar.franciscoruiz.sales.products.domain;

import ar.franciscoruiz.shared.domain.DoubleMother;

public final class ProductPriceMother {
    public static ProductPrice create(Double value) {
        return new ProductPrice(value);
    }

    public static ProductPrice random() {
        return create(DoubleMother.random());
    }
}
