package ar.franciscoruiz.authentications.users.domain;

import ar.franciscoruiz.shared.domain.WordMother;

public final class AuthenticationsUserSurnameMother {
    public static AuthenticationsUserSurname create(String value) {
        return new AuthenticationsUserSurname(value);
    }

    public static AuthenticationsUserSurname random() {
        return create(WordMother.random());
    }
}
