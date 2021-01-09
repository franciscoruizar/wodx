package ar.franciscoruiz.accounts.users.domain.coach;

import ar.franciscoruiz.accounts.roles.domain.Role;
import ar.franciscoruiz.accounts.users.domain.User;
import ar.franciscoruiz.accounts.users.domain.UserEmail;
import ar.franciscoruiz.accounts.users.domain.UserPassword;
import ar.franciscoruiz.shared.domain.users.UserId;

public final class Coach extends User {
    public Coach(UserId id, UserEmail email, UserPassword password) {
        super(id, email, password, Role.COACH);
    }

    public Coach() {
        super(null, null, null, null);
    }
}
