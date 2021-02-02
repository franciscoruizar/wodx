package ar.franciscoruiz.authentications.users.domain;

import ar.franciscoruiz.shared.domain.vo.StringValueObject;

public final class UserName extends StringValueObject {
    public UserName(String value) {
        super(value);
    }

    private UserName() {
        super(null);
    }
}
