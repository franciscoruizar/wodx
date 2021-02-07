package ar.franciscoruiz.authentications.users.domain;

import ar.franciscoruiz.shared.domain.roles.RoleId;
import ar.franciscoruiz.shared.domain.users.UserId;

import java.util.Objects;

public final class AuthenticationsUser {
    private final UserId                  id;
    private final AuthenticationsUserName    name;
    private final AuthenticationsUserSurname surname;
    private final AuthenticationsUserEmail   email;
    private final AuthenticationsUserPassword password;
    private final AuthenticationsUserPhone    phone;
    private final AuthenticationsUserIsActive isActive;
    private final RoleId                      roleId;

    public AuthenticationsUser(
        UserId id,
        AuthenticationsUserName name,
        AuthenticationsUserSurname surname,
        AuthenticationsUserEmail email,
        AuthenticationsUserPassword password,
        AuthenticationsUserPhone phone,
        AuthenticationsUserIsActive isActive,
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

    private AuthenticationsUser() {
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

    public AuthenticationsUserName name() {
        return name;
    }

    public AuthenticationsUserSurname surname() {
        return surname;
    }

    public AuthenticationsUserEmail email() {
        return email;
    }

    public AuthenticationsUserPassword password() {
        return password;
    }

    public AuthenticationsUserPhone phone() {
        return phone;
    }

    public AuthenticationsUserIsActive isActive() {
        return isActive;
    }

    public RoleId roleId() {
        return roleId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AuthenticationsUser user = (AuthenticationsUser) o;
        return Objects.equals(id, user.id) && Objects.equals(name, user.name) && Objects.equals(surname, user.surname) && Objects.equals(email, user.email) && Objects.equals(password, user.password) && Objects.equals(phone, user.phone) && Objects.equals(isActive, user.isActive) && Objects.equals(roleId, user.roleId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, surname, email, password, phone, isActive, roleId);
    }
}
