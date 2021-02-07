package ar.franciscoruiz.authentications.users.domain;

import ar.franciscoruiz.shared.domain.vo.BooleanValueObject;

public final class AuthenticationsUserIsActive extends BooleanValueObject {
    public AuthenticationsUserIsActive(Boolean value) {
        super(value == null || value);
    }

    private AuthenticationsUserIsActive() {
        super(null);
    }
}
