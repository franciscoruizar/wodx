package ar.franciscoruiz.accounts.users.domain;

import ar.franciscoruiz.shared.domain.BooleanMother;

public final class UserIsActiveMother {
    public static UserIsActive create(Boolean value) {
        return new UserIsActive(value);
    }

    public static UserIsActive random() {
        return create(BooleanMother.random());
    }
}
