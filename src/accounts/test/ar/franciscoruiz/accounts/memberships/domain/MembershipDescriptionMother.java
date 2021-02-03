package ar.franciscoruiz.accounts.memberships.domain;

import ar.franciscoruiz.shared.domain.WordMother;

public final class MembershipDescriptionMother {
    public static MembershipDescription create(String value) {
        return new MembershipDescription(value);
    }

    public static MembershipDescription random() {
        return create(WordMother.random());
    }
}
