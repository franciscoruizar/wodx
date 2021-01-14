package ar.franciscoruiz.accounts.companies.domain;

import ar.franciscoruiz.shared.domain.vo.DoubleValueObject;

public final class CompanyLatitude extends DoubleValueObject {
    public CompanyLatitude(Double value) {
        super(value);
    }

    private CompanyLatitude() {
        super(null);
    }
}
