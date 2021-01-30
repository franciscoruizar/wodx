package ar.franciscoruiz.accounts.memberships.domain;

import ar.franciscoruiz.shared.domain.vo.BooleanValueObject;

public final class MembershipIsActive extends BooleanValueObject {
    public MembershipIsActive(Boolean value) {
        super(value);
    }

    public MembershipIsActive() {
        super(null);
    }
}
