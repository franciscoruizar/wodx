package ar.franciscoruiz.authentications.auth.application.find_by_username;

import ar.franciscoruiz.shared.domain.bus.query.Query;

public final class FindAuthUserByEmailQuery implements Query {
    private final String email;

    public FindAuthUserByEmailQuery(String email) {
        this.email = email;
    }

    public String email() {
        return this.email;
    }
}
