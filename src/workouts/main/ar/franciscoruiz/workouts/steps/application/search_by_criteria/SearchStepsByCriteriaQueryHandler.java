package ar.franciscoruiz.workouts.steps.application.search_by_criteria;

import ar.franciscoruiz.shared.domain.Service;
import ar.franciscoruiz.shared.domain.bus.query.QueryHandler;
import ar.franciscoruiz.shared.domain.criteria.Filters;
import ar.franciscoruiz.shared.domain.criteria.Order;
import ar.franciscoruiz.workouts.steps.application.StepsResponse;

@Service
public final class SearchStepsByCriteriaQueryHandler implements QueryHandler<SearchStepsByCriteriaQuery, StepsResponse> {
    private final StepsByCriteriaSearcher searcher;

    public SearchStepsByCriteriaQueryHandler(StepsByCriteriaSearcher searcher) {
        this.searcher = searcher;
    }

    @Override
    public StepsResponse handle(SearchStepsByCriteriaQuery query) {
        Filters filters = Filters.fromValues(query.filters());
        Order   order   = Order.fromValues(query.orderBy(), query.orderType());

        return searcher.search(filters, order, query.limit(), query.offset());
    }
}
