package ar.franciscoruiz.authentications.users.domain;

import ar.franciscoruiz.shared.domain.WordMother;

public final class AuthenticationsUserPasswordMother {
    public static AuthenticationsUserPassword create(String value) {
        return new AuthenticationsUserPassword(value);
    }

    public static AuthenticationsUserPassword random() {
        return create(WordMother.random());
    }
}
