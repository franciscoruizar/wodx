package ar.franciscoruiz.accounts.companies.domain;

import ar.franciscoruiz.shared.domain.vo.StringValueObject;

public final class CompanyMediaUrl extends StringValueObject {
    public CompanyMediaUrl(String value) {
        super(value);
    }

    private CompanyMediaUrl() {
        super(null);
    }
}
