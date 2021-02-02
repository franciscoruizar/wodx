package ar.franciscoruiz.accounts.companies.domain;

import ar.franciscoruiz.shared.LatitudeMother;

public final class CompanyLatitudeMother {
    public static CompanyLatitude create(Double value) {
        return new CompanyLatitude(value);
    }

    public static CompanyLatitude random() {
        return create(Double.parseDouble(LatitudeMother.random()));
    }
}
