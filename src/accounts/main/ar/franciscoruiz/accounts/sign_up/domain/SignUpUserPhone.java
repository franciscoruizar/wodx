package ar.franciscoruiz.accounts.sign_up.domain;

import ar.franciscoruiz.shared.domain.vo.StringValueObject;

public final class SignUpUserPhone extends StringValueObject {
    public SignUpUserPhone(String value) {
        super(value);
    }

    private SignUpUserPhone() {
        super(null);
    }
}
