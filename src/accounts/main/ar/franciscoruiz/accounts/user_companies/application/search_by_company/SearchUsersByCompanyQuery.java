package ar.franciscoruiz.accounts.user_companies.application.search_by_company;

import ar.franciscoruiz.shared.domain.bus.query.Query;

public final class SearchUsersByCompanyQuery implements Query {
    private final String companyId;

    public SearchUsersByCompanyQuery(String companyId) {
        this.companyId = companyId;
    }

    public String companyId() {
        return companyId;
    }
}
