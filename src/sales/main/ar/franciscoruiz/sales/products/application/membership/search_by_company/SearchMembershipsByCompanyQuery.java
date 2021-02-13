package ar.franciscoruiz.sales.products.application.membership.search_by_company;

import ar.franciscoruiz.shared.domain.bus.query.Query;

public final class SearchMembershipsByCompanyQuery implements Query {
    private final String companyId;

    public SearchMembershipsByCompanyQuery(String companyId) {
        this.companyId = companyId;
    }

    public String companyId() {
        return companyId;
    }
}
