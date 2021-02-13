package ar.franciscoruiz.sales.products.application.membership.find;

import ar.franciscoruiz.shared.domain.bus.query.Query;

public final class FindMembershipQuery implements Query {
    private final String id;

    public FindMembershipQuery(String id) {
        this.id = id;
    }

    public String id() {
        return id;
    }
}
