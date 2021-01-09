package ar.franciscoruiz.accounts.role_permissions.domain;

import ar.franciscoruiz.shared.domain.DomainError;

public final class RolePermissionNotExist extends DomainError {
    public RolePermissionNotExist(RolePermissionId id) {
        super("role_permission_not_exist", String.format("The role permission <%s> doesn't exist", id.value()));
    }
}
