package ar.franciscoruiz.accounts.companies.domain;

import ar.franciscoruiz.shared.domain.vo.DoubleValueObject;

public final class CompanyLongitude extends DoubleValueObject {
    public CompanyLongitude(Double value) {
        super(value);
    }

    private CompanyLongitude() {
        super(null);
    }
}
