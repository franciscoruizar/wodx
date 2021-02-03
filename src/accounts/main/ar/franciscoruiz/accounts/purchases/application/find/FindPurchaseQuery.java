package ar.franciscoruiz.accounts.purchases.application.find;

import ar.franciscoruiz.shared.domain.bus.query.Query;

public final class FindPurchaseQuery implements Query {
    private final String id;

    public FindPurchaseQuery(String id) {
        this.id = id;
    }

    public String id() {
        return this.id;
    }
}
