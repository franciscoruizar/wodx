package ar.franciscoruiz.sales.purchases.application.search_by_user;


import ar.franciscoruiz.sales.purchases.application.PurchasesResponse;
import ar.franciscoruiz.shared.domain.Service;
import ar.franciscoruiz.shared.domain.bus.query.QueryHandler;
import ar.franciscoruiz.shared.domain.users.UserId;

@Service
public final class SearchPurchaseByUserQueryHandler implements QueryHandler<SearchPurchaseByUserQuery, PurchasesResponse> {
    private final PurchaseByUserSearcher searcher;

    public SearchPurchaseByUserQueryHandler(PurchaseByUserSearcher searcher) {
        this.searcher = searcher;
    }

    @Override
    public PurchasesResponse handle(SearchPurchaseByUserQuery query) {
        UserId userId = new UserId(query.userId());

        return searcher.search(userId);
    }
}
