package ar.franciscoruiz.accounts.memberships.domain;

import ar.franciscoruiz.shared.domain.UuidMother;

public final class MembershipIdMother {
    public static MembershipId create(String value) {
        return new MembershipId(value);
    }

    public static MembershipId random() {
        return create(UuidMother.random());
    }
}
