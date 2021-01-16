package ar.franciscoruiz.workouts.step_exercises.application.search_by_criteria;

import ar.franciscoruiz.shared.domain.bus.query.QueryHandler;
import ar.franciscoruiz.shared.domain.criteria.Filters;
import ar.franciscoruiz.shared.domain.criteria.Order;
import ar.franciscoruiz.workouts.step_exercises.application.StepExercisesResponse;

public final class SearchStepExercisesByCriteriaQueryHandler implements QueryHandler<SearchStepExercisesByCriteriaQuery, StepExercisesResponse> {
    private final StepExercisesByCriteriaSearcher searcher;

    public SearchStepExercisesByCriteriaQueryHandler(StepExercisesByCriteriaSearcher searcher) {
        this.searcher = searcher;
    }

    @Override
    public StepExercisesResponse handle(SearchStepExercisesByCriteriaQuery query) {
        Filters filters = Filters.fromValues(query.filters());
        Order   order   = Order.fromValues(query.orderBy(), query.orderType());

        return searcher.search(filters, order, query.limit(), query.offset());
    }
}
