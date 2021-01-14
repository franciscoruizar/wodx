package ar.franciscoruiz.accounts.role_permissions.domain;

import ar.franciscoruiz.accounts.permissions.domain.PermissionId;
import ar.franciscoruiz.accounts.roles.domain.RoleId;

public final class RolePermission {
    private final RolePermissionId id;
    private final RoleId           roleId;
    private final PermissionId     permissionId;

    public RolePermission(RolePermissionId id, RoleId roleId, PermissionId permissionId) {
        this.id           = id;
        this.roleId       = roleId;
        this.permissionId = permissionId;
    }

    public RolePermission() {
        this.id           = null;
        this.roleId       = null;
        this.permissionId = null;
    }

    public RolePermissionId id() {
        return this.id;
    }

    public RoleId roleId() {
        return this.roleId;
    }

    public PermissionId permissionId() {
        return this.permissionId;
    }
}
