package ar.franciscoruiz.accounts.user_companies.application.search_by_user;

import ar.franciscoruiz.accounts.companies.application.CompanyResponse;
import ar.franciscoruiz.accounts.companies.domain.CompanyDomainFinder;
import ar.franciscoruiz.accounts.user_companies.domain.UserCompanyRepository;
import ar.franciscoruiz.shared.domain.Service;
import ar.franciscoruiz.shared.domain.users.UserId;

import java.util.stream.Collectors;

@Service
public final class CompaniesByUserSearcher {
    private final UserCompanyRepository repository;
    private final CompanyDomainFinder   companyDomainFinder;

    public CompaniesByUserSearcher(UserCompanyRepository repository, CompanyDomainFinder companyDomainFinder) {
        this.repository          = repository;
        this.companyDomainFinder = companyDomainFinder;
    }

    public CompaniesByUserResponse search(UserId userId) {
        return new CompaniesByUserResponse(
            this.repository.searchByUser(userId)
                .stream()
                .map(companyId -> CompanyResponse.fromAggregate(this.companyDomainFinder.find(companyId)))
                .collect(Collectors.toList())
        );
    }
}
