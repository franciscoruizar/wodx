package ar.franciscoruiz.accounts.role_permissions.application;

import ar.franciscoruiz.accounts.role_permissions.domain.RolePermission;
import ar.franciscoruiz.accounts.roles.application.RoleResponse;
import ar.franciscoruiz.shared.domain.bus.query.Response;

public final class RolePermissionResponse implements Response {
    private final String       id;
    private final RoleResponse role;
    private final String       permissionId;

    public RolePermissionResponse(String id, RoleResponse role, String permissionId) {
        this.id           = id;
        this.role         = role;
        this.permissionId = permissionId;
    }

    public static RolePermissionResponse fromAggregate(RolePermission entity) {
        return new RolePermissionResponse(
            entity.id().value(),
            RoleResponse.fromAggregate(entity.role()),
            entity.permissionId().value()
        );
    }

    public String id() {
        return this.id;
    }

    public RoleResponse role() {
        return this.role;
    }

    public String permissionId() {
        return this.permissionId;
    }
}
