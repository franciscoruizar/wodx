package ar.franciscoruiz.accounts.user_memberships.application.search_by_user;

import ar.franciscoruiz.shared.domain.bus.query.Query;

public final class SearchUserMembershipByUserQuery implements Query {
    private final String id;

    public SearchUserMembershipByUserQuery(String id) {
        this.id = id;
    }

    public String id() {
        return id;
    }
}
