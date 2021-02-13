package ar.franciscoruiz.sales.products.domain.material_product;

import ar.franciscoruiz.shared.domain.IntegerMother;

public final class MaterialProductWeightMother {
    public static MaterialProductWeight create(Integer value) {
        return new MaterialProductWeight(value);
    }

    public static MaterialProductWeight random() {
        return create(IntegerMother.random());
    }
}
