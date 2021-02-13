package ar.franciscoruiz.accounts.companies.domain;

import ar.franciscoruiz.shared.domain.Service;
import ar.franciscoruiz.shared.domain.companies.CompanyId;

@Service
public final class CompanyDomainFinder {
    private final CompanyRepository repository;

    public CompanyDomainFinder(CompanyRepository repository) {
        this.repository = repository;
    }

    public Company find(CompanyId id) {
        return this.repository
            .search(id)
            .orElseThrow(() -> new CompanyNotExist(id));
    }
}
