package ar.franciscoruiz.authentications.users.domain;

import ar.franciscoruiz.shared.domain.BooleanMother;

public final class AuthenticationsUserIsActiveMother {
    public static AuthenticationsUserIsActive create(Boolean value) {
        return new AuthenticationsUserIsActive(value);
    }

    public static AuthenticationsUserIsActive random() {
        return create(BooleanMother.random());
    }
}
