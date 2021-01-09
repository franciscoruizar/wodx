package ar.franciscoruiz.accounts.users.domain.athlete;

import ar.franciscoruiz.accounts.roles.domain.Role;
import ar.franciscoruiz.accounts.users.domain.User;
import ar.franciscoruiz.accounts.users.domain.UserEmail;
import ar.franciscoruiz.accounts.users.domain.UserPassword;
import ar.franciscoruiz.shared.domain.users.UserId;

public final class Athlete extends User {
    public Athlete(UserId id, UserEmail email, UserPassword password) {
        super(id, email, password, Role.ATHLETE);
    }

    public Athlete() {
        super(null, null, null, null);
    }
}
