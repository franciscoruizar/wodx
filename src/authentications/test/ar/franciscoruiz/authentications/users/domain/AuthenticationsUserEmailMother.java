package ar.franciscoruiz.authentications.users.domain;

import ar.franciscoruiz.shared.domain.EmailMother;

public final class AuthenticationsUserEmailMother {
    public static AuthenticationsUserEmail create(String value) {
        return new AuthenticationsUserEmail(value);
    }

    public static AuthenticationsUserEmail random() {
        return create(EmailMother.random());
    }
}
