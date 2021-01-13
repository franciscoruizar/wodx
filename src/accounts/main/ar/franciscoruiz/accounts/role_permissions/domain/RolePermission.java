package ar.franciscoruiz.accounts.role_permissions.domain;

import ar.franciscoruiz.accounts.permissions.domain.PermissionId;
import ar.franciscoruiz.accounts.roles.domain.RoleId;

import java.util.Objects;

public final class RolePermission {
    private final RolePermissionId id;
    private final RoleId           role;
    private final PermissionId     permissionId;

    public RolePermission(RolePermissionId id, RoleId role, PermissionId permissionId) {
        this.id           = id;
        this.role         = role;
        this.permissionId = permissionId;
    }

    public RolePermission() {
        this.id           = null;
        this.role         = null;
        this.permissionId = null;
    }

    public RolePermissionId id() {
        return this.id;
    }

    public RoleId role() {
        return this.role;
    }

    public PermissionId permissionId() {
        return this.permissionId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RolePermission that = (RolePermission) o;
        return Objects.equals(id, that.id) && Objects.equals(role, that.role) && Objects.equals(permissionId, that.permissionId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, role, permissionId);
    }
}
