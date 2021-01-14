package ar.franciscoruiz.accounts.auth.domain;

import ar.franciscoruiz.shared.domain.vo.StringValueObject;

public final class AuthUsername extends StringValueObject {
    public AuthUsername(String value) {
        super(value);
    }

    private AuthUsername() {
        super(null);
    }
}
