package ar.franciscoruiz.accounts.sign_up.domain;

import ar.franciscoruiz.accounts.roles.domain.RoleId;

public final class SignUpUser {
    private final SignUpUserId       id;
    private final SignUpUserName     name;
    private final SignUpUserSurname  surname;
    private final SignUpUserEmail    email;
    private final SignUpUserPassword password;
    private final SignUpUserPhone    phone;
    private final RoleId             roleId;

    public SignUpUser(
        SignUpUserId id,
        SignUpUserName name,
        SignUpUserSurname surname,
        SignUpUserEmail email,
        SignUpUserPassword password,
        SignUpUserPhone phone
    ) {
        this.id       = id;
        this.name     = name;
        this.surname  = surname;
        this.email    = email;
        this.password = password;
        this.phone    = phone;
        this.roleId   = new RoleId("6e5cbf77-8a3b-45ed-98d2-6f97a08c0ca1");
    }

    public SignUpUser() {
        this.id       = null;
        this.name     = null;
        this.surname  = null;
        this.email    = null;
        this.password = null;
        this.phone    = null;
        this.roleId   = null;
    }

    public SignUpUserId id() {
        return this.id;
    }

    public SignUpUserName name() {
        return this.name;
    }

    public SignUpUserSurname surname() {
        return this.surname;
    }

    public SignUpUserEmail email() {
        return this.email;
    }

    public SignUpUserPassword password() {
        return this.password;
    }

    public SignUpUserPhone phone() {
        return this.phone;
    }
}
