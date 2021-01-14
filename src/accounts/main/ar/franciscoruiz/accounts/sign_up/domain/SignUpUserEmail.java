package ar.franciscoruiz.accounts.sign_up.domain;

import ar.franciscoruiz.shared.domain.vo.StringValueObject;

public final class SignUpUserEmail extends StringValueObject {
    public SignUpUserEmail(String value) {
        super(value);
    }

    private SignUpUserEmail() {
        super(null);
    }
}
