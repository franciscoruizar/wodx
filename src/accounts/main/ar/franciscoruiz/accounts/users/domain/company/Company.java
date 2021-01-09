package ar.franciscoruiz.accounts.users.domain.company;

import ar.franciscoruiz.accounts.roles.domain.Role;
import ar.franciscoruiz.accounts.users.domain.User;
import ar.franciscoruiz.accounts.users.domain.UserEmail;
import ar.franciscoruiz.accounts.users.domain.UserPassword;
import ar.franciscoruiz.shared.domain.users.UserId;

public final class Company extends User {
    public Company(UserId id, UserEmail email, UserPassword password) {
        super(id, email, password, Role.COMPANY);
    }

    public Company() {
        super(null, null, null, null);
    }
}
