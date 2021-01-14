package ar.franciscoruiz.accounts.user_companies.application.search_by_criteria;

import ar.franciscoruiz.accounts.companies.application.CompanyResponse;
import ar.franciscoruiz.accounts.companies.application.find.FindCompanyQuery;
import ar.franciscoruiz.accounts.user_companies.application.UserCompaniesResponse;
import ar.franciscoruiz.accounts.user_companies.application.UserCompanyResponse;
import ar.franciscoruiz.accounts.user_companies.domain.UserCompanyRepository;
import ar.franciscoruiz.accounts.users.application.UserResponse;
import ar.franciscoruiz.accounts.users.application.find.FindUserQuery;
import ar.franciscoruiz.shared.domain.Service;
import ar.franciscoruiz.shared.domain.bus.query.QueryBus;
import ar.franciscoruiz.shared.domain.criteria.Criteria;
import ar.franciscoruiz.shared.domain.criteria.Filters;
import ar.franciscoruiz.shared.domain.criteria.Order;

import java.util.Optional;
import java.util.stream.Collectors;

@Service
public final class UserCompanyByCriteriaSearcher {
    private final UserCompanyRepository repository;
    private final QueryBus              queryBus;

    public UserCompanyByCriteriaSearcher(UserCompanyRepository repository, QueryBus queryBus) {
        this.repository = repository;
        this.queryBus   = queryBus;
    }

    public UserCompaniesResponse search(
        Filters filters,
        Order order,
        Optional<Integer> limit,
        Optional<Integer> offset
    ) {
        Criteria criteria = new Criteria(filters, order, limit, offset);

        return new UserCompaniesResponse(
            this.repository
                .matching(criteria)
                .stream()
                .map(userCompany -> new UserCompanyResponse(
                    userCompany.id(),
                    findUser(userCompany.userId()),
                    findCompany(userCompany.companyId())
                ))
                .collect(Collectors.toList())
        );
    }

    public CompanyResponse findCompany(String id) {
        return this.queryBus.ask(new FindCompanyQuery(id));
    }

    public UserResponse findUser(String id) {
        return this.queryBus.ask(new FindUserQuery(id));
    }
}
