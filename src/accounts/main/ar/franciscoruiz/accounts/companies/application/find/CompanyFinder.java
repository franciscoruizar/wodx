package ar.franciscoruiz.accounts.companies.application.find;

import ar.franciscoruiz.accounts.companies.application.CompanyResponse;
import ar.franciscoruiz.accounts.companies.domain.CompanyDomainFinder;
import ar.franciscoruiz.accounts.companies.domain.CompanyId;
import ar.franciscoruiz.accounts.companies.domain.CompanyRepository;
import ar.franciscoruiz.shared.domain.Service;

@Service
public final class CompanyFinder {
    private final CompanyDomainFinder finder;

    public CompanyFinder(CompanyRepository repository) {
        this.finder = new CompanyDomainFinder(repository);
    }

    public CompanyResponse find(CompanyId id) {
        return CompanyResponse.fromAggregate(this.finder.find(id));
    }
}
