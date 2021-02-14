package ar.franciscoruiz.sales.account_statements.application.search_by_company;

import ar.franciscoruiz.sales.account_statements.application.AccountStatementsResponse;
import ar.franciscoruiz.shared.domain.Service;
import ar.franciscoruiz.shared.domain.bus.query.QueryHandler;
import ar.franciscoruiz.shared.domain.companies.CompanyId;

@Service
public final class SearchAccountStatementByCompanyQueryHandler implements QueryHandler<SearchAccountStatementByCompanyQuery, AccountStatementsResponse> {
    private final AccountStatementByCompanySearcher searcher;

    public SearchAccountStatementByCompanyQueryHandler(AccountStatementByCompanySearcher searcher) {
        this.searcher = searcher;
    }

    @Override
    public AccountStatementsResponse handle(SearchAccountStatementByCompanyQuery query) {
        CompanyId companyId = new CompanyId(query.companyId());

        return this.searcher.find(companyId);
    }
}
