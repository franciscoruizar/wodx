package ar.franciscoruiz.accounts.users.domain;

import ar.franciscoruiz.shared.domain.vo.StringValueObject;

public final class UserEmail extends StringValueObject {
    public UserEmail(String value) {
        super(value);
    }

    private UserEmail() {
        super(null);
    }
}
