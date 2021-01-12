package ar.franciscoruiz.workouts.step_exercises.application.search_by_criteria;

import ar.franciscoruiz.shared.domain.Service;
import ar.franciscoruiz.shared.domain.bus.query.QueryBus;
import ar.franciscoruiz.shared.domain.criteria.Criteria;
import ar.franciscoruiz.shared.domain.criteria.Filters;
import ar.franciscoruiz.shared.domain.criteria.Order;
import ar.franciscoruiz.workouts.exercises.application.ExerciseResponse;
import ar.franciscoruiz.workouts.exercises.application.find.FindExerciseQuery;
import ar.franciscoruiz.workouts.exercises.domain.ExerciseId;
import ar.franciscoruiz.workouts.step_exercises.StepExercisesResponse;
import ar.franciscoruiz.workouts.step_exercises.application.StepExerciseResponse;
import ar.franciscoruiz.workouts.step_exercises.domain.StepExerciseRepository;
import ar.franciscoruiz.workouts.steps.domain.Step;
import ar.franciscoruiz.workouts.steps.domain.StepRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public final class StepExercisesByCriteriaSearcher {
    private final StepExerciseRepository repository;
    private final QueryBus               queryBus;

    public StepExercisesByCriteriaSearcher(StepExerciseRepository repository, QueryBus queryBus) {
        this.repository = repository;
        this.queryBus   = queryBus;
    }

    public StepExercisesResponse search(
        Filters filters,
        Order order,
        Optional<Integer> limit,
        Optional<Integer> offset
    ) {
        Criteria criteria = new Criteria(filters, order, limit, offset);

        return new StepExercisesResponse(
            repository.matching(criteria)
                        .stream()
                        .map((stepExercise) -> new StepExerciseResponse(
                            stepExercise.id().value(),
                            stepExercise.series().value(),
                            stepExercise.value().value(),
                            stepExercise.timeUnit().toString(),
                            stepExercise.stepId().value(),
                            findExercise(stepExercise.exerciseId())
                        ))
                        .collect(Collectors.toList())
        );
    }

    private ExerciseResponse findExercise(ExerciseId id) {
        return this.queryBus.ask(new FindExerciseQuery(id.value()));
    }
}
