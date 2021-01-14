package ar.franciscoruiz.accounts.roles.application;

import ar.franciscoruiz.accounts.permissions.application.PermissionsResponse;
import ar.franciscoruiz.accounts.roles.domain.Role;
import ar.franciscoruiz.shared.domain.bus.query.Response;

import java.util.ArrayList;

public final class RoleResponse implements Response {
    private final String              id;
    private final String              description;
    private final PermissionsResponse permissions;

    public RoleResponse(String id, String description, PermissionsResponse permissions) {
        this.id          = id;
        this.description = description;
        this.permissions = permissions;
    }

    public static RoleResponse fromAggregate(Role entity, PermissionsResponse permissions) {
        return new RoleResponse(
            entity.id().value(),
            entity.description().value(),
            permissions
        );
    }

    public static RoleResponse fromAggregate(Role entity) {
        return new RoleResponse(
            entity.id().value(),
            entity.description().value(),
            new PermissionsResponse(new ArrayList<>())
        );
    }

    public String id() {
        return this.id;
    }

    public String description() {
        return this.description;
    }

    public PermissionsResponse permissions() {
        return this.permissions;
    }
}
