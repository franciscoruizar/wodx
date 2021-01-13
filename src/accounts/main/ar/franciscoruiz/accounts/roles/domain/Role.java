package ar.franciscoruiz.accounts.roles.domain;

import java.util.Objects;

public final class Role {
    private final RoleId          id;
    private final RoleDescription description;

    public Role(RoleId id, RoleDescription description) {
        this.id          = id;
        this.description = description;
    }

    public RoleId id() {
        return this.id;
    }

    public RoleDescription description() {
        return this.description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Role role = (Role) o;
        return Objects.equals(id, role.id) && Objects.equals(description, role.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, description);
    }
}
