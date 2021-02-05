package ar.franciscoruiz.accounts.user_companies.application.search_by_company;

import ar.franciscoruiz.accounts.companies.domain.CompanyId;
import ar.franciscoruiz.shared.domain.Service;
import ar.franciscoruiz.shared.domain.bus.query.QueryHandler;

@Service
public final class SearchUsersByCompanyQueryHandler implements QueryHandler<SearchUsersByCompanyQuery, UsersByCompanyResponse> {
    private final UsersByCompanySearcher searcher;

    public SearchUsersByCompanyQueryHandler(UsersByCompanySearcher searcher) {
        this.searcher = searcher;
    }

    @Override
    public UsersByCompanyResponse handle(SearchUsersByCompanyQuery query) {
        CompanyId companyId = new CompanyId(query.companyId());

        return this.searcher.search(companyId);
    }
}
