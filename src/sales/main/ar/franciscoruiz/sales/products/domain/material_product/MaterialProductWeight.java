package ar.franciscoruiz.sales.products.domain.material_product;

import ar.franciscoruiz.shared.domain.vo.IntValueObject;

public final class MaterialProductWeight extends IntValueObject {
    public MaterialProductWeight(Integer value) {
        super(value);
    }

    private MaterialProductWeight() {
        super(null);
    }
}
