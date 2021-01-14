package ar.franciscoruiz.accounts.user_companies.application.search_by_criteria;

import ar.franciscoruiz.accounts.user_companies.application.UserCompaniesResponse;
import ar.franciscoruiz.shared.domain.Service;
import ar.franciscoruiz.shared.domain.bus.query.QueryHandler;
import ar.franciscoruiz.shared.domain.criteria.Filters;
import ar.franciscoruiz.shared.domain.criteria.Order;

@Service
public final class SearchUserCompanyByCriteriaQueryHandler implements QueryHandler<SearchUserCompanyByCriteriaQuery, UserCompaniesResponse> {
    private final UserCompanyByCriteriaSearcher searcher;

    public SearchUserCompanyByCriteriaQueryHandler(UserCompanyByCriteriaSearcher searcher) {
        this.searcher = searcher;
    }

    @Override
    public UserCompaniesResponse handle(SearchUserCompanyByCriteriaQuery query) {
        Filters filters = Filters.fromValues(query.filters());
        Order   order   = Order.fromValues(query.orderBy(), query.orderType());

        return searcher.search(filters, order, query.limit(), query.offset());
    }
}
