package ar.franciscoruiz.accounts.permissions.domain;

import ar.franciscoruiz.shared.domain.vo.StringValueObject;

public final class PermissionEntity extends StringValueObject {
    public PermissionEntity(String value) {
        super(value);
    }

    private PermissionEntity() {
        super(null);
    }
}
