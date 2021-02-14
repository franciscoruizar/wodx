package ar.franciscoruiz.sales.account_statements.application.search_by_user_company;

import ar.franciscoruiz.sales.account_statements.application.AccountStatementResponse;
import ar.franciscoruiz.shared.domain.Service;
import ar.franciscoruiz.shared.domain.bus.query.QueryHandler;
import ar.franciscoruiz.shared.domain.companies.CompanyId;
import ar.franciscoruiz.shared.domain.users.UserId;

@Service
public final class SearchAccountStatementByUserCompanyQueryHandler implements QueryHandler<SearchAccountStatementByUserCompanyQuery, AccountStatementResponse> {
    private final AccountStatementByUserCompanySearcher searcher;

    public SearchAccountStatementByUserCompanyQueryHandler(AccountStatementByUserCompanySearcher searcher) {
        this.searcher = searcher;
    }

    @Override
    public AccountStatementResponse handle(SearchAccountStatementByUserCompanyQuery query) {
        UserId    userId    = new UserId(query.userId());
        CompanyId companyId = new CompanyId(query.companyId());

        return this.searcher.find(userId, companyId);
    }
}
