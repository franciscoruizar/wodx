package ar.franciscoruiz.shared.domain.auth;

import ar.franciscoruiz.shared.domain.EmailMother;

public final class AuthEmailMother {
    public static AuthEmail create(String value) {
        return new AuthEmail(value);
    }

    public static AuthEmail random() {
        return create(EmailMother.random());
    }
}
