package ar.franciscoruiz.accounts.roles.domain;

import ar.franciscoruiz.shared.domain.vo.StringValueObject;

public final class RoleDescription extends StringValueObject {
    public RoleDescription(String value) {
        super(value);
    }

    private RoleDescription() {
        super(null);
    }
}
