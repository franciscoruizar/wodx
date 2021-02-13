package ar.franciscoruiz.sales.products.application.material_product;

import ar.franciscoruiz.sales.products.application.ProductResponse;
import ar.franciscoruiz.sales.products.domain.material_product.MaterialProduct;

import java.io.Serializable;
import java.util.HashMap;

public final class MaterialProductResponse extends ProductResponse {
    private final Integer weight;

    public MaterialProductResponse(String id, String title, String description, Double price, boolean isActive, String companyId, Integer weight) {
        super(id, title, description, price, isActive, companyId);
        this.weight = weight;
    }

    public static MaterialProductResponse fromAggregate(MaterialProduct entity) {
        return new MaterialProductResponse(
            entity.id().value(),
            entity.title().value(),
            entity.description().value(),
            entity.price().value(),
            entity.isActive().value(),
            entity.companyId().value(),
            entity.weight().value()
        );
    }

    @Override
    protected HashMap<String, Serializable> toPrimitives() {
        var primitives = super.toPrimitives();

        primitives.put("weight", this.weight);

        return primitives;
    }

    public Integer weight() {
        return weight;
    }
}
