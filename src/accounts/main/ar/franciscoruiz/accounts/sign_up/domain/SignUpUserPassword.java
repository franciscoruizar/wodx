package ar.franciscoruiz.accounts.sign_up.domain;

import ar.franciscoruiz.shared.domain.vo.StringValueObject;

public final class SignUpUserPassword extends StringValueObject {
    public SignUpUserPassword(String value) {
        super(value);
    }

    private SignUpUserPassword() {
        super(null);
    }
}
