package ar.franciscoruiz.authentications.users.domain;

import ar.franciscoruiz.shared.domain.vo.StringValueObject;

public final class AuthenticationsUserEmail extends StringValueObject {
    public AuthenticationsUserEmail(String value) {
        super(value);
    }

    private AuthenticationsUserEmail() {
        super(null);
    }
}
