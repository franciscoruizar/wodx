package ar.franciscoruiz.accounts.user_memberships.application.find;

import ar.franciscoruiz.shared.domain.bus.query.Query;

public final class FindUserMembershipQuery implements Query {
    private final String id;

    public FindUserMembershipQuery(String id) {
        this.id = id;
    }

    public String id() {
        return this.id;
    }
}
