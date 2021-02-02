package ar.franciscoruiz.accounts.companies.application.search_all;

import ar.franciscoruiz.accounts.companies.application.CompaniesResponse;
import ar.franciscoruiz.accounts.companies.application.CompanyResponse;
import ar.franciscoruiz.accounts.companies.domain.CompanyRepository;
import ar.franciscoruiz.shared.domain.Service;

import java.util.stream.Collectors;

@Service
public final class AllCompaniesSearcher {
    private final CompanyRepository repository;

    public AllCompaniesSearcher(CompanyRepository repository) {
        this.repository = repository;
    }

    public CompaniesResponse search() {
        return new CompaniesResponse(
            this.repository.findAll()
                .stream()
                .map(CompanyResponse::fromAggregate)
                .collect(Collectors.toList())
        );
    }
}
