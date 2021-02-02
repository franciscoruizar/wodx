package ar.franciscoruiz.authentications.users.domain;

import ar.franciscoruiz.shared.domain.vo.StringValueObject;

public final class UserPhone extends StringValueObject {
    public UserPhone(String value) {
        super(value);
    }

    private UserPhone() {
        super(null);
    }
}
