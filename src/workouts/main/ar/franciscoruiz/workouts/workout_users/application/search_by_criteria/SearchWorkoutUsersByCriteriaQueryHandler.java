package ar.franciscoruiz.workouts.workout_users.application.search_by_criteria;

import ar.franciscoruiz.shared.domain.Service;
import ar.franciscoruiz.shared.domain.bus.query.QueryHandler;
import ar.franciscoruiz.shared.domain.criteria.Filters;
import ar.franciscoruiz.shared.domain.criteria.Order;
import ar.franciscoruiz.workouts.workout_users.application.WorkoutUsersResponse;

@Service
public final class SearchWorkoutUsersByCriteriaQueryHandler implements QueryHandler<SearchWorkoutUsersByCriteriaQuery, WorkoutUsersResponse> {
    private final WorkoutUsersByCriteriaSearcher searcher;

    public SearchWorkoutUsersByCriteriaQueryHandler(WorkoutUsersByCriteriaSearcher searcher) {
        this.searcher = searcher;
    }

    @Override
    public WorkoutUsersResponse handle(SearchWorkoutUsersByCriteriaQuery query) {
        Filters filters = Filters.fromValues(query.filters());
        Order   order   = Order.fromValues(query.orderBy(), query.orderType());

        return searcher.search(filters, order, query.limit(), query.offset());
    }
}
