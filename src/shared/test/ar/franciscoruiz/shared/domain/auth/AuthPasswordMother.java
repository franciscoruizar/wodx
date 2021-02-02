package ar.franciscoruiz.shared.domain.auth;

import ar.franciscoruiz.shared.domain.WordMother;

public final class AuthPasswordMother {
    public static AuthPassword create(String value) {
        return new AuthPassword(value);
    }

    public static AuthPassword random() {
        return create(WordMother.random());
    }
}
