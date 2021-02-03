package ar.franciscoruiz.accounts.memberships.domain;

import ar.franciscoruiz.shared.domain.DoubleMother;

public final class MembershipPriceMother {
    public static MembershipPrice create(Double value) {
        return new MembershipPrice(value);
    }

    public static MembershipPrice random() {
        return create(DoubleMother.random());
    }
}
