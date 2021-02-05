package ar.franciscoruiz.accounts.user_memberships.application.search_by_membership;

import ar.franciscoruiz.shared.domain.bus.query.Query;

public final class SearchUserMembershipByMembershipQuery implements Query {
    private final String id;

    public SearchUserMembershipByMembershipQuery(String id) {
        this.id = id;
    }

    public String id() {
        return id;
    }
}
