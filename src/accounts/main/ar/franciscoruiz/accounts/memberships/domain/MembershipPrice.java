package ar.franciscoruiz.accounts.memberships.domain;

import ar.franciscoruiz.shared.domain.vo.DoubleValueObject;

public final class MembershipPrice extends DoubleValueObject {
    public MembershipPrice(Double value) {
        super(value);
    }

    public MembershipPrice() {
        super(null);
    }
}
