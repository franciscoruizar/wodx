package ar.franciscoruiz.accounts.memberships.application.search_by_company;

import ar.franciscoruiz.shared.domain.bus.query.Query;

public final class SearchMembershipByCompany implements Query {
    private final String companyId;

    public SearchMembershipByCompany(String companyId) {
        this.companyId = companyId;
    }

    public String companyId() {
        return companyId;
    }
}
