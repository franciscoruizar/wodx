package ar.franciscoruiz.shared.domain.companies;

import ar.franciscoruiz.shared.domain.UuidMother;

public final class CompanyIdMother {
    public static CompanyId create(String value) {
        return new CompanyId(value);
    }

    public static CompanyId random() {
        return create(UuidMother.random());
    }
}
