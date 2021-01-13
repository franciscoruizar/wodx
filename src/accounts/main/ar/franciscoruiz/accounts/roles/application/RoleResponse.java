package ar.franciscoruiz.accounts.roles.application;

import ar.franciscoruiz.accounts.roles.domain.Role;
import ar.franciscoruiz.accounts.roles.domain.RoleId;
import ar.franciscoruiz.shared.domain.bus.query.Response;

public final class RoleResponse implements Response {
    private final String id;
    private final String description;

    public RoleResponse(String id, String description) {
        this.id          = id;
        this.description = description;
    }

    public static RoleResponse fromAggregate(Role entity) {
        return new RoleResponse(entity.value(), entity.name());
    }

    public static RoleResponse fromAggregate(RoleId id) {
        return fromAggregate(Role.valueOf(id.value()));
    }

    public String id() {
        return this.id;
    }

    public String description() {
        return this.description;
    }
}
