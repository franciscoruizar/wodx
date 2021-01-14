package ar.franciscoruiz.accounts.companies.application.find;

import ar.franciscoruiz.accounts.companies.application.CompanyResponse;
import ar.franciscoruiz.accounts.companies.domain.CompanyId;
import ar.franciscoruiz.accounts.companies.domain.CompanyNotExist;
import ar.franciscoruiz.accounts.companies.domain.CompanyRepository;
import ar.franciscoruiz.shared.domain.Service;

@Service
public final class CompanyFinder {
    private final CompanyRepository repository;

    public CompanyFinder(CompanyRepository repository) {
        this.repository = repository;
    }

    public CompanyResponse find(CompanyId id) {
        return this.repository
            .search(id)
            .map(CompanyResponse::fromAggregate)
            .orElseThrow(() -> new CompanyNotExist(id));
    }
}
