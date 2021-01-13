package ar.franciscoruiz.accounts.role_permissions.application.search_by_criteria;

import ar.franciscoruiz.accounts.role_permissions.application.RolePermissionsResponse;
import ar.franciscoruiz.shared.domain.Service;
import ar.franciscoruiz.shared.domain.bus.query.QueryHandler;
import ar.franciscoruiz.shared.domain.criteria.Filters;
import ar.franciscoruiz.shared.domain.criteria.Order;

@Service
public final class SearchRolePermissionByCriteriaQueryHandler implements QueryHandler<SearchRolePermissionByCriteriaQuery, RolePermissionsResponse> {
    private final RolePermissionByCriteriaSearcher searcher;

    public SearchRolePermissionByCriteriaQueryHandler(RolePermissionByCriteriaSearcher searcher) {
        this.searcher = searcher;
    }

    @Override
    public RolePermissionsResponse handle(SearchRolePermissionByCriteriaQuery query) {
        Filters filters = Filters.fromValues(query.filters());
        Order   order   = Order.fromValues(query.orderBy(), query.orderType());

        return searcher.search(filters, order, query.limit(), query.offset());
    }
}
