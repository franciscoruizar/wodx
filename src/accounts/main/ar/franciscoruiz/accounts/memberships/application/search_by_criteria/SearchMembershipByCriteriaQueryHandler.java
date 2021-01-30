package ar.franciscoruiz.accounts.memberships.application.search_by_criteria;

import ar.franciscoruiz.accounts.memberships.application.MembershipsResponse;
import ar.franciscoruiz.shared.domain.Service;
import ar.franciscoruiz.shared.domain.bus.query.QueryHandler;
import ar.franciscoruiz.shared.domain.criteria.Filters;
import ar.franciscoruiz.shared.domain.criteria.Order;

@Service
public final class SearchMembershipByCriteriaQueryHandler implements QueryHandler<SearchMembershipByCriteriaQuery, MembershipsResponse> {
    private final MembershipByCriteriaSearcher searcher;

    public SearchMembershipByCriteriaQueryHandler(MembershipByCriteriaSearcher searcher) {
        this.searcher = searcher;
    }

    @Override
    public MembershipsResponse handle(SearchMembershipByCriteriaQuery query) {
        Filters filters = Filters.fromValues(query.filters());
        Order   order   = Order.fromValues(query.orderBy(), query.orderType());

        return searcher.search(filters, order, query.limit(), query.offset());
    }
}
