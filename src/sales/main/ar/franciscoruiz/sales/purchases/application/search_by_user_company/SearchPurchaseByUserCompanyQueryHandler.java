package ar.franciscoruiz.sales.purchases.application.search_by_user_company;


import ar.franciscoruiz.sales.purchases.application.PurchasesResponse;
import ar.franciscoruiz.shared.domain.Service;
import ar.franciscoruiz.shared.domain.bus.query.QueryHandler;
import ar.franciscoruiz.shared.domain.companies.CompanyId;
import ar.franciscoruiz.shared.domain.users.UserId;

@Service
public final class SearchPurchaseByUserCompanyQueryHandler implements QueryHandler<SearchPurchaseByUserCompanyQuery, PurchasesResponse> {
    private final PurchaseByUserCompanySearcher searcher;

    public SearchPurchaseByUserCompanyQueryHandler(PurchaseByUserCompanySearcher searcher) {
        this.searcher = searcher;
    }

    @Override
    public PurchasesResponse handle(SearchPurchaseByUserCompanyQuery query) {
        UserId    userId    = new UserId(query.userId());
        CompanyId companyId = new CompanyId(query.companyId());

        return searcher.search(userId, companyId);
    }
}
