package ar.franciscoruiz.authentications.users.domain;

import ar.franciscoruiz.shared.domain.WordMother;

public final class UserSurnameMother {
    public static UserSurname create(String value) {
        return new UserSurname(value);
    }

    public static UserSurname random() {
        return create(WordMother.random());
    }
}
