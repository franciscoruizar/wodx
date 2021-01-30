package ar.franciscoruiz.shared.domain.auth;

import ar.franciscoruiz.shared.domain.vo.StringValueObject;

public final class AuthPassword extends StringValueObject {
    public AuthPassword(String value) {
        super(value);
    }

    private AuthPassword() {
        super(null);
    }
}
