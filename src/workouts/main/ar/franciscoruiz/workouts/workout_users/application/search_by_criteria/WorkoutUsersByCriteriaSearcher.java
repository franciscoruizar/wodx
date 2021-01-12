package ar.franciscoruiz.workouts.workout_users.application.search_by_criteria;

import ar.franciscoruiz.shared.domain.Service;
import ar.franciscoruiz.shared.domain.criteria.Criteria;
import ar.franciscoruiz.shared.domain.criteria.Filters;
import ar.franciscoruiz.shared.domain.criteria.Order;
import ar.franciscoruiz.workouts.workout_users.application.WorkoutUserResponse;
import ar.franciscoruiz.workouts.workout_users.application.WorkoutUsersResponse;
import ar.franciscoruiz.workouts.workout_users.domain.WorkoutUserRepository;

import java.util.Optional;
import java.util.stream.Collectors;

@Service
public final class WorkoutUsersByCriteriaSearcher {
    private final WorkoutUserRepository repository;

    public WorkoutUsersByCriteriaSearcher(WorkoutUserRepository repository) {
        this.repository = repository;
    }

    public WorkoutUsersResponse search(
        Filters filters,
        Order order,
        Optional<Integer> limit,
        Optional<Integer> offset
    ) {
        Criteria criteria = new Criteria(filters, order, limit, offset);

        return new WorkoutUsersResponse(
            repository.matching(criteria)
                .stream()
                .map(WorkoutUserResponse::fromAggregate)
                .collect(Collectors.toList())
        );
    }
}
