package ar.franciscoruiz.accounts.companies.domain;

import ar.franciscoruiz.shared.domain.vo.StringValueObject;

public final class CompanyDescription extends StringValueObject {
    public CompanyDescription(String value) {
        super(value);
    }

    private CompanyDescription() {
        super(null);
    }
}
