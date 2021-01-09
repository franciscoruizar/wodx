package ar.franciscoruiz.accounts.users.domain;

import ar.franciscoruiz.shared.domain.vo.StringValueObject;

public final class UserPassword extends StringValueObject {
    public UserPassword(String value) {
        super(value);
    }

    private UserPassword() {
        super(null);
    }
}
