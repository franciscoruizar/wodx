package ar.franciscoruiz.accounts.users.domain;

import java.util.Objects;

public final class User {
    private final String  id;
    private final String  name;
    private final String  surname;
    private final String  email;
    private final String  phone;
    private final Boolean isActive;
    private final String  roleId;

    public User(
        String id,
        String name,
        String surname,
        String email,
        String phone,
        Boolean isActive,
        String roleId
    ) {
        this.id       = id;
        this.name     = name;
        this.surname  = surname;
        this.email    = email;
        this.phone    = phone;
        this.isActive = isActive;
        this.roleId   = roleId;
    }

    private User() {
        this.id       = null;
        this.name     = null;
        this.surname  = null;
        this.email    = null;
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

    public String phone() {
        return this.phone;
    }

    public Boolean isActive() {
        return this.isActive;
    }

    public String roleId() {
        return this.roleId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id) && Objects.equals(name, user.name) && Objects.equals(surname, user.surname) && Objects.equals(email, user.email) && Objects.equals(phone, user.phone) && Objects.equals(isActive, user.isActive) && Objects.equals(roleId, user.roleId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, surname, email, phone, isActive, roleId);
    }
}
