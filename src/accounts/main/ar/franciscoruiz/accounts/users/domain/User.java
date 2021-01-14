package ar.franciscoruiz.accounts.users.domain;

import ar.franciscoruiz.accounts.roles.domain.RoleId;
import ar.franciscoruiz.shared.domain.users.UserId;

public final class User {
    private final String  id;
    private final String  name;
    private final String  surname;
    private final String  email;
    private final String  password;
    private final String  phone;
    private final Boolean isActive;
    private final String  roleId;

    public User(
        String id,
        String name,
        String surname,
        String email,
        String password,
        String phone,
        Boolean isActive,
        String roleId
    ) {
        this.id       = id;
        this.name     = name;
        this.surname  = surname;
        this.email    = email;
        this.password = password;
        this.phone    = phone;
        this.isActive = isActive;
        this.roleId   = roleId;
    }

    public User() {
        this.id       = null;
        this.name     = null;
        this.surname  = null;
        this.email    = null;
        this.password = null;
        this.phone    = null;
        this.isActive = null;
        this.roleId   = null;
    }

    public String id() {
        return this.id;
    }

    public String name() {
        return this.name;
    }

    public String surname() {
        return this.surname;
    }

    public String email() {
        return this.email;
    }

    public String password() {
        return this.password;
    }

    public String phone() {
        return this.phone;
    }

    public Boolean isActive() {
        return this.isActive;
    }

    public String roleId() {
        return this.roleId;
    }
}
