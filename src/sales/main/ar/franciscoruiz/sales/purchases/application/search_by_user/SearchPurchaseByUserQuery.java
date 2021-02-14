package ar.franciscoruiz.sales.purchases.application.search_by_user;

import ar.franciscoruiz.shared.domain.bus.query.Query;

public final class SearchPurchaseByUserQuery implements Query {
    private final String userId;

    public SearchPurchaseByUserQuery(String userId) {
        this.userId = userId;
    }

    public String userId() {
        return userId;
    }
}
