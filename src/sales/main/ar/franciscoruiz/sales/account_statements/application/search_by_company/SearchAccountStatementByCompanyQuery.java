package ar.franciscoruiz.sales.account_statements.application.search_by_company;

import ar.franciscoruiz.shared.domain.bus.query.Query;

public final class SearchAccountStatementByCompanyQuery implements Query {
    private final String companyId;

    public SearchAccountStatementByCompanyQuery(String companyId) {
        this.companyId = companyId;
    }

    public String companyId() {
        return companyId;
    }
}
