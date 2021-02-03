package ar.franciscoruiz.accounts.purchases.application.search_by_company;

import ar.franciscoruiz.accounts.companies.domain.CompanyId;
import ar.franciscoruiz.accounts.purchases.application.PurchasesResponse;
import ar.franciscoruiz.shared.domain.Service;
import ar.franciscoruiz.shared.domain.bus.query.QueryHandler;

@Service
public final class SearchPurchaseByCompanyQueryHandler implements QueryHandler<SearchPurchaseByCompanyQuery, PurchasesResponse> {
    private final PurchaseByCompanySearcher searcher;

    public SearchPurchaseByCompanyQueryHandler(PurchaseByCompanySearcher searcher) {
        this.searcher = searcher;
    }

    @Override
    public PurchasesResponse handle(SearchPurchaseByCompanyQuery query) {
        CompanyId companyId = new CompanyId(query.companyId());

        return searcher.search(companyId);
    }
}
