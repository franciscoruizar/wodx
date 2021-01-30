package ar.franciscoruiz.shared.domain.auth;

import ar.franciscoruiz.shared.domain.vo.StringValueObject;

public final class AuthEmail extends StringValueObject {
    public AuthEmail(String value) {
        super(value);
    }

    private AuthEmail() {
        super(null);
    }
}
