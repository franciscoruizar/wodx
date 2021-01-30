package ar.franciscoruiz.accounts.purchases.application.search_by_criteria;

import ar.franciscoruiz.accounts.purchases.application.PurchasesResponse;
import ar.franciscoruiz.shared.domain.Service;
import ar.franciscoruiz.shared.domain.bus.query.QueryHandler;
import ar.franciscoruiz.shared.domain.criteria.Filters;
import ar.franciscoruiz.shared.domain.criteria.Order;

@Service
public final class SearchPurchaseByCriteriaQueryHandler implements QueryHandler<SearchPurchaseByCriteriaQuery, PurchasesResponse> {
    private final PurchaseByCriteriaSearcher searcher;

    public SearchPurchaseByCriteriaQueryHandler(PurchaseByCriteriaSearcher searcher) {
        this.searcher = searcher;
    }

    @Override
    public PurchasesResponse handle(SearchPurchaseByCriteriaQuery query) {
        Filters filters = Filters.fromValues(query.filters());
        Order   order   = Order.fromValues(query.orderBy(), query.orderType());

        return searcher.search(filters, order, query.limit(), query.offset());
    }
}
