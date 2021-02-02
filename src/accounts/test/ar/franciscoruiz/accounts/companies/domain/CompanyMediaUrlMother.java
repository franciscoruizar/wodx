package ar.franciscoruiz.accounts.companies.domain;

import ar.franciscoruiz.shared.domain.MediaUrlMother;

public final class CompanyMediaUrlMother {
    public static CompanyMediaUrl create(String value) {
        return new CompanyMediaUrl(value);
    }

    public static CompanyMediaUrl random() {
        return create(MediaUrlMother.random().value());
    }
}
