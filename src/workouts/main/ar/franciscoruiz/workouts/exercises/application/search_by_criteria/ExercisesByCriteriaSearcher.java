package ar.franciscoruiz.workouts.exercises.application.search_by_criteria;

import ar.franciscoruiz.shared.domain.Service;
import ar.franciscoruiz.shared.domain.criteria.Criteria;
import ar.franciscoruiz.shared.domain.criteria.Filters;
import ar.franciscoruiz.shared.domain.criteria.Order;
import ar.franciscoruiz.workouts.exercises.application.ExerciseResponse;
import ar.franciscoruiz.workouts.exercises.application.ExercisesResponse;
import ar.franciscoruiz.workouts.exercises.domain.ExerciseRepository;

import java.util.Optional;
import java.util.stream.Collectors;

@Service
public final class ExercisesByCriteriaSearcher {
    private final ExerciseRepository repository;

    public ExercisesByCriteriaSearcher(ExerciseRepository repository) {
        this.repository = repository;
    }

    public ExercisesResponse search(
        Filters filters,
        Order order,
        Optional<Integer> limit,
        Optional<Integer> offset
    ) {
        Criteria criteria = new Criteria(filters, order, limit, offset);

        return new ExercisesResponse(
            repository.matching(criteria)
                .stream()
                .map(ExerciseResponse::fromAggregate)
                .collect(Collectors.toList())
        );
    }
}
