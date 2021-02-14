package ar.franciscoruiz.sales.purchases.application.search_by_user_company;

import ar.franciscoruiz.shared.domain.bus.query.Query;

public final class SearchPurchaseByUserCompanyQuery implements Query {
    private final String userId;
    private final String companyId;

    public SearchPurchaseByUserCompanyQuery(String userId, String companyId) {
        this.userId    = userId;
        this.companyId = companyId;
    }

    public String userId() {
        return userId;
    }

    public String companyId() {
        return companyId;
    }
}
