package ar.franciscoruiz.accounts.role_permissions.application;

import ar.franciscoruiz.shared.domain.bus.query.Response;

import java.util.List;

public final class RolePermissionsResponse implements Response {
    private final List<RolePermissionResponse> values;

    public RolePermissionsResponse(List<RolePermissionResponse> values) {
        this.values = values;
    }

    public List<RolePermissionResponse> values() {
        return this.values;
    }
}
