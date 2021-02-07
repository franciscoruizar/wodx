package ar.franciscoruiz.authentications.users.domain;

import ar.franciscoruiz.shared.domain.vo.StringValueObject;

public final class AuthenticationsUserPhone extends StringValueObject {
    public AuthenticationsUserPhone(String value) {
        super(value);
    }

    private AuthenticationsUserPhone() {
        super(null);
    }
}
