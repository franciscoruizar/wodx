package ar.franciscoruiz.accounts.companies.domain;

import ar.franciscoruiz.shared.domain.MotherCreator;

public final class CompanyDescriptionMother {
    public static CompanyDescription create(String value) {
        return new CompanyDescription(value);
    }

    public static CompanyDescription random() {
        return create(MotherCreator.random().company().name());
    }
}
