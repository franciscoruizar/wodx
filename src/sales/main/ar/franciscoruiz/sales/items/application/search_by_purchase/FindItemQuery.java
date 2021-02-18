package ar.franciscoruiz.sales.items.application.search_by_purchase;

import ar.franciscoruiz.shared.domain.bus.query.Query;

public final class FindItemQuery implements Query {
    private final String id;

    public FindItemQuery(String id) {
        this.id = id;
    }

    public String id() {
        return this.id;
    }
}
