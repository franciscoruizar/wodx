package ar.franciscoruiz.accounts.sign_up.domain;

import ar.franciscoruiz.shared.domain.vo.StringValueObject;

public final class SignUpUserSurname extends StringValueObject {
    public SignUpUserSurname(String value) {
        super(value);
    }

    private SignUpUserSurname() {
        super(null);
    }
}
