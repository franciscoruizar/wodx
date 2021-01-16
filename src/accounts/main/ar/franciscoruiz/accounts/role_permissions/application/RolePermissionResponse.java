package ar.franciscoruiz.accounts.role_permissions.application;

import ar.franciscoruiz.accounts.role_permissions.domain.RolePermission;
import ar.franciscoruiz.shared.domain.bus.query.Response;

public final class RolePermissionResponse implements Response {
    private final String id;
    private final String roleId;
    private final String permissionId;

    public RolePermissionResponse(String id, String roleId, String permissionId) {
        this.id           = id;
        this.roleId       = roleId;
        this.permissionId = permissionId;
    }

    public static RolePermissionResponse fromAggregate(RolePermission entity) {
        return new RolePermissionResponse(
            entity.id().value(),
            entity.roleId().value(),
            entity.permissionId().value()
        );
    }

    public String id() {
        return this.id;
    }

    public String roleId() {
        return this.roleId;
    }

    public String permissionId() {
        return this.permissionId;
    }
}
