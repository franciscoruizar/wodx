package ar.franciscoruiz.accounts.users.domain.admin;

import ar.franciscoruiz.accounts.roles.domain.Role;
import ar.franciscoruiz.accounts.users.domain.User;
import ar.franciscoruiz.accounts.users.domain.UserEmail;
import ar.franciscoruiz.accounts.users.domain.UserPassword;
import ar.franciscoruiz.shared.domain.users.UserId;

public final class Admin extends User {
    public Admin(UserId id, UserEmail email, UserPassword password) {
        super(id, email, password, Role.ADMIN);
    }

    public Admin() {
        super(null, null, null, null);
    }
}
