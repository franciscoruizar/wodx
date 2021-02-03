package ar.franciscoruiz.accounts.memberships.domain;

import ar.franciscoruiz.shared.domain.BooleanMother;

public final class MembershipIsActiveMother {
    public static MembershipIsActive create(Boolean value) {
        return new MembershipIsActive(value);
    }

    public static MembershipIsActive random() {
        return create(BooleanMother.random());
    }
}
