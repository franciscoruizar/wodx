package ar.franciscoruiz.accounts.users.application;

import ar.franciscoruiz.accounts.roles.application.RoleResponse;
import ar.franciscoruiz.accounts.users.domain.User;
import ar.franciscoruiz.shared.domain.bus.query.Response;

public final class UserResponse implements Response {
    private final String       id;
    private final String       email;
    private final RoleResponse role;

    public UserResponse(String id, String email, RoleResponse role) {
        this.id    = id;
        this.email = email;
        this.role  = role;
    }

    public static UserResponse fromAggregate(User entity) {
        return new UserResponse(
            entity.id().value(),
            entity.email().value(),
            RoleResponse.fromAggregate(entity.role())
        );
    }

    public String id() {
        return this.id;
    }

    public String email() {
        return this.email;
    }

    public RoleResponse role() {
        return this.role;
    }
}
