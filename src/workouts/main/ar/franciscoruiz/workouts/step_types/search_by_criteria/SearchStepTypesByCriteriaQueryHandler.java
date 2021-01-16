package ar.franciscoruiz.workouts.step_types.search_by_criteria;

import ar.franciscoruiz.shared.domain.Service;
import ar.franciscoruiz.shared.domain.bus.query.QueryHandler;
import ar.franciscoruiz.shared.domain.criteria.Filters;
import ar.franciscoruiz.shared.domain.criteria.Order;
import ar.franciscoruiz.workouts.step_types.application.StepTypesResponse;

@Service
public final class SearchStepTypesByCriteriaQueryHandler implements QueryHandler<SearchStepTypesByCriteriaQuery, StepTypesResponse> {
    private final StepTypesByCriteriaSearcher searcher;

    public SearchStepTypesByCriteriaQueryHandler(StepTypesByCriteriaSearcher searcher) {
        this.searcher = searcher;
    }

    @Override
    public StepTypesResponse handle(SearchStepTypesByCriteriaQuery query) {
        Filters filters = Filters.fromValues(query.filters());
        Order   order   = Order.fromValues(query.orderBy(), query.orderType());

        return searcher.search(filters, order, query.limit(), query.offset());
    }
}
