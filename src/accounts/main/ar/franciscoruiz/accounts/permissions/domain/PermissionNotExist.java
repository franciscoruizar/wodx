package ar.franciscoruiz.accounts.permissions.domain;

import ar.franciscoruiz.shared.domain.DomainError;

public final class PermissionNotExist extends DomainError {
    public PermissionNotExist(PermissionId id) {
        super("permission_not_exist", String.format("The permission <%s> doesn't exist", id.value()));
    }
}
