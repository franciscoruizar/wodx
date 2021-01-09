package ar.franciscoruiz.accounts.users.domain;

import ar.franciscoruiz.accounts.roles.domain.Role;
import ar.franciscoruiz.shared.domain.users.UserId;

import java.util.Objects;

public abstract class User {
    private final UserId       id;
    private final UserEmail    email;
    private final UserPassword password;
    private final Role         role;

    public User(UserId id, UserEmail email, UserPassword password, Role role) {
        this.id       = id;
        this.email    = email;
        this.password = password;
        this.role     = role;
    }

    public User() {
        this.id       = null;
        this.email    = null;
        this.password = null;
        this.role     = null;
    }

    public UserId id() {
        return this.id;
    }

    public UserEmail email() {
        return this.email;
    }

    public UserPassword password() {
        return this.password;
    }

    public Role role() {
        return this.role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id) && Objects.equals(email, user.email) && Objects.equals(password, user.password) && Objects.equals(role, user.role);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, email, password, role);
    }
}
