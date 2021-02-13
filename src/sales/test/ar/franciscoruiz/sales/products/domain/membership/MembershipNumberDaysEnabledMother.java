package ar.franciscoruiz.sales.products.domain.membership;

import ar.franciscoruiz.shared.domain.IntegerMother;

public final class MembershipNumberDaysEnabledMother {
    public static MembershipNumberDaysEnabled create(Integer value) {
        return new MembershipNumberDaysEnabled(value);
    }

    public static MembershipNumberDaysEnabled random() {
        return create(IntegerMother.random());
    }
}
