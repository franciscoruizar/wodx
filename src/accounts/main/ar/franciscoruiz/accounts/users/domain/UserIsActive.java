package ar.franciscoruiz.accounts.users.domain;

import ar.franciscoruiz.shared.domain.vo.BooleanValueObject;

public final class UserIsActive extends BooleanValueObject {
    public UserIsActive(Boolean value) {
        super(value == null || value);
    }

    private UserIsActive() {
        super(null);
    }
}
