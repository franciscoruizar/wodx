package ar.franciscoruiz.accounts.users.domain;

import ar.franciscoruiz.shared.domain.vo.StringValueObject;

public final class UserPhone extends StringValueObject {
    public UserPhone(String value) {
        super(value);
    }

    private UserPhone() {
        super(null);
    }
}
