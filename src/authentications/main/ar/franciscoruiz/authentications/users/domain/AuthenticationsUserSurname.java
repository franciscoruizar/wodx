package ar.franciscoruiz.authentications.users.domain;

import ar.franciscoruiz.shared.domain.vo.StringValueObject;

public final class AuthenticationsUserSurname extends StringValueObject {
    public AuthenticationsUserSurname(String value) {
        super(value);
    }

    private AuthenticationsUserSurname() {
        super(null);
    }
}
