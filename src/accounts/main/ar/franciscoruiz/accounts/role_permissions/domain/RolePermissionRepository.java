package ar.franciscoruiz.accounts.role_permissions.domain;

import ar.franciscoruiz.accounts.roles.domain.RoleId;

import java.util.List;
import java.util.Optional;

public interface RolePermissionRepository {
    Optional<RolePermission> search(RolePermissionId id);

    List<RolePermission> searchByRole(RoleId roleId);
}
