package ar.franciscoruiz.accounts.permissions.application.search_by_criteria;

import ar.franciscoruiz.accounts.permissions.application.PermissionsResponse;
import ar.franciscoruiz.shared.domain.Service;
import ar.franciscoruiz.shared.domain.bus.query.QueryHandler;
import ar.franciscoruiz.shared.domain.criteria.Filters;
import ar.franciscoruiz.shared.domain.criteria.Order;

@Service
public final class SearchPermissionByCriteriaQueryHandler implements QueryHandler<SearchPermissionByCriteriaQuery, PermissionsResponse> {
    private final PermissionByCriteriaSearcher searcher;

    public SearchPermissionByCriteriaQueryHandler(PermissionByCriteriaSearcher searcher) {
        this.searcher = searcher;
    }

    @Override
    public PermissionsResponse handle(SearchPermissionByCriteriaQuery query) {
        Filters filters = Filters.fromValues(query.filters());
        Order   order   = Order.fromValues(query.orderBy(), query.orderType());

        return searcher.search(filters, order, query.limit(), query.offset());
    }
}
