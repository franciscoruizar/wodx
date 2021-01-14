package ar.franciscoruiz.accounts.sign_up.domain;

import ar.franciscoruiz.shared.domain.vo.StringValueObject;

public final class SignUpUserName extends StringValueObject {
    public SignUpUserName(String value) {
        super(value);
    }

    private SignUpUserName() {
        super(null);
    }
}
