package ar.franciscoruiz.sales.account_statements.application.search_by_user_company;

import ar.franciscoruiz.shared.domain.bus.query.Query;

public final class SearchAccountStatementByUserCompanyQuery implements Query {
    private final String userId;
    private final String companyId;

    public SearchAccountStatementByUserCompanyQuery(String userId, String companyId) {
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
