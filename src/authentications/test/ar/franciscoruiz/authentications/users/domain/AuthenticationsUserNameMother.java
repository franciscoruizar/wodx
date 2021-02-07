package ar.franciscoruiz.authentications.users.domain;

import ar.franciscoruiz.shared.domain.WordMother;

public final class AuthenticationsUserNameMother {
    public static AuthenticationsUserName create(String value) {
        return new AuthenticationsUserName(value);
    }

    public static AuthenticationsUserName random() {
        return create(WordMother.random());
    }
}
