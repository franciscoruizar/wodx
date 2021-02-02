package ar.franciscoruiz.authentications.users.domain;

import ar.franciscoruiz.shared.domain.roles.RoleId;
import ar.franciscoruiz.shared.domain.users.UserId;

import java.util.Objects;

public final class User {
    private final UserId       id;
    private final UserName     name;
    private final UserSurname  surname;
    private final UserEmail    email;
    private final UserPassword password;
    private final UserPhone    phone;
    private final UserIsActive isActive;
    private final RoleId       roleId;

    public User(
        UserId id,
        UserName name,
        UserSurname surname,
        UserEmail email,
        UserPassword password,
        UserPhone phone,
        UserIsActive isActive,
        RoleId roleId
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

    private User() {
        this.id       = null;
        this.name     = null;
        this.surname  = null;
        this.email    = null;
        this.password = null;
        this.phone    = null;
        this.isActive = null;
        this.roleId   = null;
    }

    public UserId id() {
        return id;
    }

    public UserName name() {
        return name;
    }

    public UserSurname surname() {
        return surname;
    }

    public UserEmail email() {
        return email;
    }

    public UserPassword password() {
        return password;
    }

    public UserPhone phone() {
        return phone;
    }

    public UserIsActive isActive() {
        return isActive;
    }

    public RoleId roleId() {
        return roleId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id) && Objects.equals(name, user.name) && Objects.equals(surname, user.surname) && Objects.equals(email, user.email) && Objects.equals(password, user.password) && Objects.equals(phone, user.phone) && Objects.equals(isActive, user.isActive) && Objects.equals(roleId, user.roleId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, surname, email, password, phone, isActive, roleId);
    }
}
