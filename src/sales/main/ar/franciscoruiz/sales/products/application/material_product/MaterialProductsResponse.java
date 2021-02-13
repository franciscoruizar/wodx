package ar.franciscoruiz.sales.products.application.material_product;

import ar.franciscoruiz.shared.domain.bus.query.Response;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public final class MaterialProductsResponse implements Response {
    private final List<MaterialProductResponse> values;

    public MaterialProductsResponse(List<MaterialProductResponse> values) {
        this.values = values;
    }

    public List<MaterialProductResponse> values() {
        return this.values;
    }

    public List<HashMap<String, Serializable>> toPrimitives() {
        return this.values
            .stream()
            .map(MaterialProductResponse::toPrimitives)
            .collect(Collectors.toList());
    }
}
