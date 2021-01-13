package ar.franciscoruiz.accounts.permissions.application.find;

import ar.franciscoruiz.shared.domain.bus.query.Query;

public final class FindPermissionQuery implements Query {
    private final String id;

    public FindPermissionQuery(String id) {
        this.id = id;
    }

    public String id() {
        return this.id;
    }
}
