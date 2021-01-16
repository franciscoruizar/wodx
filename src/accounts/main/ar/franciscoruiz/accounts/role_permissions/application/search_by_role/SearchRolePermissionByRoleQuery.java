package ar.franciscoruiz.accounts.role_permissions.application.search_by_role;

import ar.franciscoruiz.shared.domain.bus.query.Query;

public final class SearchRolePermissionByRoleQuery implements Query {
    private final String id;

    public SearchRolePermissionByRoleQuery(String id) {
        this.id = id;
    }

    public String id() {
        return this.id;
    }
}
