package ar.franciscoruiz.accounts.user_companies.application.search_by_company;

import ar.franciscoruiz.accounts.companies.domain.CompanyId;
import ar.franciscoruiz.accounts.user_companies.domain.UserCompanyRepository;
import ar.franciscoruiz.accounts.users.application.UserResponse;
import ar.franciscoruiz.accounts.users.domain.User;
import ar.franciscoruiz.accounts.users.domain.UserDomainFinder;
import ar.franciscoruiz.shared.domain.Service;
import ar.franciscoruiz.shared.domain.users.UserId;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public final class UsersByCompanySearcher {
    private final UserCompanyRepository repository;
    private final UserDomainFinder      userDomainFinder;

    public UsersByCompanySearcher(UserCompanyRepository repository, UserDomainFinder userDomainFinder) {
        this.repository       = repository;
        this.userDomainFinder = userDomainFinder;
    }

    public UsersByCompanyResponse search(CompanyId companyId) {
        return new UsersByCompanyResponse(
            this.repository.searchByCompany(companyId)
                .stream()
                .map(userId -> UserResponse.fromAggregate(this.userDomainFinder.find(userId)))
                .collect(Collectors.toList())
        );
    }
}
