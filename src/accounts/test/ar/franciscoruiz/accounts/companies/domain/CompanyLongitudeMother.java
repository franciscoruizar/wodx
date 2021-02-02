package ar.franciscoruiz.accounts.companies.domain;

import ar.franciscoruiz.shared.LongitudeMother;

public final class CompanyLongitudeMother {
    public static CompanyLongitude create(Double value) {
        return new CompanyLongitude(value);
    }

    public static CompanyLongitude random() {
        return create(Double.parseDouble(LongitudeMother.random()));
    }
}
