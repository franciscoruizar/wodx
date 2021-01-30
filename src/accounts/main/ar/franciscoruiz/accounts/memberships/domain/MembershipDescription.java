package ar.franciscoruiz.accounts.memberships.domain;

import ar.franciscoruiz.shared.domain.vo.StringValueObject;

public final class MembershipDescription extends StringValueObject {
    public MembershipDescription(String value) {
        super(value);
    }

    public MembershipDescription() {
        super(null);
    }
}
