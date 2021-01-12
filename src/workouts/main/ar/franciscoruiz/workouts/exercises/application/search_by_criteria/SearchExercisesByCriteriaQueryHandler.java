package ar.franciscoruiz.workouts.exercises.application.search_by_criteria;

import ar.franciscoruiz.shared.domain.Service;
import ar.franciscoruiz.shared.domain.bus.query.QueryHandler;
import ar.franciscoruiz.shared.domain.criteria.Filters;
import ar.franciscoruiz.shared.domain.criteria.Order;
import ar.franciscoruiz.workouts.exercises.application.ExercisesResponse;

@Service
public final class SearchExercisesByCriteriaQueryHandler implements QueryHandler<SearchExercisesByCriteriaQuery, ExercisesResponse> {
    private final ExercisesByCriteriaSearcher searcher;

    public SearchExercisesByCriteriaQueryHandler(ExercisesByCriteriaSearcher searcher) {
        this.searcher = searcher;
    }

    @Override
    public ExercisesResponse handle(SearchExercisesByCriteriaQuery query) {
        Filters filters = Filters.fromValues(query.filters());
        Order   order   = Order.fromValues(query.orderBy(), query.orderType());

        return searcher.search(filters, order, query.limit(), query.offset());
    }
}
