package ar.franciscoruiz.accounts.roles.domain;

public final class Role {
    private final RoleId          id;
    private final RoleDescription description;

    public Role(RoleId id, RoleDescription description) {
        this.id          = id;
        this.description = description;
    }

    public Role() {
        this.id          = null;
        this.description = null;
    }

    public RoleId id() {
        return this.id;
    }

    public RoleDescription description() {
        return this.description;
    }
}
