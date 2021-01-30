package ar.franciscoruiz.accounts.memberships.application.find;

import ar.franciscoruiz.shared.domain.bus.query.Query;

public final class FindMembershipQuery implements Query {
    private final String id;

    public FindMembershipQuery(String id) {
        this.id = id;
    }

    public String id() {
        return this.id;
    }
}
