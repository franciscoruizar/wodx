package ar.franciscoruiz.accounts.roles.domain;

import ar.franciscoruiz.shared.domain.DomainError;
import ar.franciscoruiz.shared.domain.roles.RoleId;

public final class RoleNotExist extends DomainError {
    public RoleNotExist(RoleId id) {
        super("role_not_exist", String.format("The role <%s> doesn't exist", id.value()));
    }
}
