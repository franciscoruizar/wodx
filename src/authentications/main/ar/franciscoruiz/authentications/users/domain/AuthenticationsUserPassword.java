package ar.franciscoruiz.authentications.users.domain;

import ar.franciscoruiz.shared.domain.vo.StringValueObject;

public final class AuthenticationsUserPassword extends StringValueObject {
    public AuthenticationsUserPassword(String value) {
        super(value);
    }

    private AuthenticationsUserPassword() {
        super(null);
    }
}
