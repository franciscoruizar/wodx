package ar.franciscoruiz.accounts.role_permissions.application.find;

import ar.franciscoruiz.shared.domain.bus.query.Query;

public final class FindRolePermissionQuery implements Query {
    private final String id;

    public FindRolePermissionQuery(String id) {
        this.id = id;
    }

    public String id() {
        return this.id;
    }
}
