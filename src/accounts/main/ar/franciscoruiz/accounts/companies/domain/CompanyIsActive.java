package ar.franciscoruiz.accounts.companies.domain;

import ar.franciscoruiz.shared.domain.vo.BooleanValueObject;

public final class CompanyIsActive extends BooleanValueObject {
    public CompanyIsActive(Boolean value) {
        super(value);
    }

    private CompanyIsActive() {
        super(false);
    }
}
