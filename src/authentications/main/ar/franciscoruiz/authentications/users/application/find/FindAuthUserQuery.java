package ar.franciscoruiz.authentications.users.application.find;

import ar.franciscoruiz.shared.domain.bus.query.Query;

public final class FindAuthUserQuery implements Query {
    private final String id;

    public FindAuthUserQuery(String id) {
        this.id = id;
    }

    public String id() {
        return this.id;
    }
}
