package ar.franciscoruiz.accounts.companies.domain;

import ar.franciscoruiz.shared.domain.BooleanMother;

public final class CompanyIsActiveMother {
    public static CompanyIsActive create(Boolean value) {
        return new CompanyIsActive(value);
    }

    public static CompanyIsActive random() {
        return create(BooleanMother.random());
    }
}
