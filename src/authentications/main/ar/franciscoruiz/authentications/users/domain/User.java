package ar.franciscoruiz.authentications.users.domain;

import ar.franciscoruiz.shared.domain.roles.RoleId;
import ar.franciscoruiz.shared.domain.users.UserId;

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
}
