package ar.franciscoruiz.accounts.companies.domain;

public final class CompanyMother {
    public static Company create(
        CompanyId id,
        CompanyDescription description,
        CompanyMediaUrl mediaUrl,
        CompanyLatitude latitude,
        CompanyLongitude longitude,
        CompanyIsActive isActive
    ) {
        return new Company(id, description, mediaUrl, latitude, longitude, isActive);
    }

    public static Company random() {
        return create(
            CompanyIdMother.random(),
            CompanyDescriptionMother.random(),
            CompanyMediaUrlMother.random(),
            CompanyLatitudeMother.random(),
            CompanyLongitudeMother.random(),
            CompanyIsActiveMother.random()
        );
    }
}
