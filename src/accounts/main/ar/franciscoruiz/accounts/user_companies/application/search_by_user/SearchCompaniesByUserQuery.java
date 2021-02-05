package ar.franciscoruiz.accounts.user_companies.application.search_by_user;

import ar.franciscoruiz.shared.domain.bus.query.Query;

public final class SearchCompaniesByUserQuery implements Query {
    private final String userId;

    public SearchCompaniesByUserQuery(String userId) {
        this.userId = userId;
    }

    public String userId() {
        return userId;
    }
}
