package ar.franciscoruiz.sales.products.application.material_product.find;

import ar.franciscoruiz.shared.domain.bus.query.Query;

public final class FindMaterialProductQuery implements Query {
    private final String id;

    public FindMaterialProductQuery(String id) {
        this.id = id;
    }

    public String id() {
        return id;
    }
}
