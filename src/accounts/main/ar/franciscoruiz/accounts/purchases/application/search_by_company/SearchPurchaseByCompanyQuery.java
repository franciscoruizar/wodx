package ar.franciscoruiz.accounts.purchases.application.search_by_company;

import ar.franciscoruiz.shared.domain.bus.query.Query;

public final class SearchPurchaseByCompanyQuery implements Query {
    private final String companyId;

    public SearchPurchaseByCompanyQuery(String companyId) {
        this.companyId = companyId;
    }

    public String companyId() {
        return companyId;
    }
}