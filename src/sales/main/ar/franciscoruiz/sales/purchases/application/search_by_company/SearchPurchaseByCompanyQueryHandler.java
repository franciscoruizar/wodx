package ar.franciscoruiz.sales.purchases.application.search_by_company;


import ar.franciscoruiz.sales.purchases.application.PurchasesResponse;
import ar.franciscoruiz.shared.domain.Service;
import ar.franciscoruiz.shared.domain.bus.query.QueryHandler;
import ar.franciscoruiz.shared.domain.companies.CompanyId;

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
