package ar.franciscoruiz.accounts.companies.application.create;

import ar.franciscoruiz.accounts.companies.domain.*;
import ar.franciscoruiz.shared.domain.Service;
import ar.franciscoruiz.shared.domain.companies.CompanyId;

@Service
public final class CompanyCreator {
    private final CompanyRepository repository;

    public CompanyCreator(CompanyRepository repository) {
        this.repository = repository;
    }

    public void create(
        CompanyId id,
        CompanyDescription description,
        CompanyMediaUrl mediaUrl,
        CompanyLatitude latitude,
        CompanyLongitude longitude,
        CompanyIsActive isActive
    ) {
        Company company = new Company(id, description, mediaUrl, latitude, longitude, isActive);

        this.repository.save(company);
    }
}
