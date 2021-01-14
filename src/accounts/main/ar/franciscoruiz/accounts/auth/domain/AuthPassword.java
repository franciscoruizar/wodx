package ar.franciscoruiz.accounts.auth.domain;

import ar.franciscoruiz.shared.domain.vo.StringValueObject;

public final class AuthPassword  extends StringValueObject {
    public AuthPassword(String value) {
        super(value);
    }

    private AuthPassword() {
        super(null);
    }
}
