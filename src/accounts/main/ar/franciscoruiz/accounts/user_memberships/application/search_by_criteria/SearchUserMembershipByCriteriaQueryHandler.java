package ar.franciscoruiz.accounts.user_memberships.application.search_by_criteria;

import ar.franciscoruiz.accounts.user_memberships.application.UserMembershipsResponse;
import ar.franciscoruiz.shared.domain.Service;
import ar.franciscoruiz.shared.domain.bus.query.QueryHandler;
import ar.franciscoruiz.shared.domain.criteria.Filters;
import ar.franciscoruiz.shared.domain.criteria.Order;

@Service
public final class SearchUserMembershipByCriteriaQueryHandler implements QueryHandler<SearchUserMembershipByCriteriaQuery, UserMembershipsResponse> {
    private final UserMembershipByCriteriaSearcher searcher;

    public SearchUserMembershipByCriteriaQueryHandler(UserMembershipByCriteriaSearcher searcher) {
        this.searcher = searcher;
    }

    @Override
    public UserMembershipsResponse handle(SearchUserMembershipByCriteriaQuery query) {
        Filters filters = Filters.fromValues(query.filters());
        Order   order   = Order.fromValues(query.orderBy(), query.orderType());

        return searcher.search(filters, order, query.limit(), query.offset());
    }
}
