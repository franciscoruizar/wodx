package ar.franciscoruiz.accounts.users.domain;

import ar.franciscoruiz.shared.domain.vo.StringValueObject;

public final class UserSurname extends StringValueObject {
    public UserSurname(String value) {
        super(value);
    }

    private UserSurname() {
        super(null);
    }
}
