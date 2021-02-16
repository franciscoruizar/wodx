package ar.franciscoruiz.accounts.users.application.find_by_email;

import ar.franciscoruiz.shared.domain.bus.query.Query;

public final class FindUserByEmailQuery implements Query {
    private final String email;

    public FindUserByEmailQuery(String email) {
        this.email = email;
    }

    public String email() {
        return this.email;
    }
}
