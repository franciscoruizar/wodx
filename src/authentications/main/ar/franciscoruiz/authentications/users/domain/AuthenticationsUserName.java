package ar.franciscoruiz.authentications.users.domain;

import ar.franciscoruiz.shared.domain.vo.StringValueObject;

public final class AuthenticationsUserName extends StringValueObject {
    public AuthenticationsUserName(String value) {
        super(value);
    }

    private AuthenticationsUserName() {
        super(null);
    }
}
