package ar.franciscoruiz.authentications.users.domain;

import ar.franciscoruiz.shared.domain.PhoneNumberMother;

public final class AuthenticationsUserPhoneMother {
    public static AuthenticationsUserPhone create(String value) {
        return new AuthenticationsUserPhone(value);
    }

    public static AuthenticationsUserPhone random() {
        return create(PhoneNumberMother.random());
    }
}
