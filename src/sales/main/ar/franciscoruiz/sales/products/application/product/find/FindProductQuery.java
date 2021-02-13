package ar.franciscoruiz.sales.products.application.product.find;

import ar.franciscoruiz.shared.domain.bus.query.Query;

public final class FindProductQuery implements Query {
    private final String id;

    public FindProductQuery(String id) {
        this.id = id;
    }

    public String id() {
        return id;
    }
}
