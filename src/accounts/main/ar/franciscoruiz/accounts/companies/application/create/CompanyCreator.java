package ar.franciscoruiz.accounts.companies.application.create;

import ar.franciscoruiz.accounts.companies.domain.Company;
import ar.franciscoruiz.accounts.companies.domain.CompanyDescription;
import ar.franciscoruiz.accounts.companies.domain.CompanyId;
import ar.franciscoruiz.accounts.companies.domain.CompanyRepository;
import ar.franciscoruiz.shared.domain.Service;

@Service
public final class CompanyCreator {
    private final CompanyRepository repository;

    public CompanyCreator(CompanyRepository repository) {
        this.repository = repository;
    }

    public void create(CompanyId id, CompanyDescription description) {
        Company company = new Company(id, description);

        this.repository.save(company);
    }
}
