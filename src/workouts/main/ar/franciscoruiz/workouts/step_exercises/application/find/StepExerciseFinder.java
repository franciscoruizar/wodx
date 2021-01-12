package ar.franciscoruiz.workouts.step_exercises.application.find;

import ar.franciscoruiz.shared.domain.Service;
import ar.franciscoruiz.shared.domain.bus.query.QueryBus;
import ar.franciscoruiz.workouts.exercises.application.ExerciseResponse;
import ar.franciscoruiz.workouts.exercises.application.find.FindExerciseQuery;
import ar.franciscoruiz.workouts.exercises.domain.ExerciseId;
import ar.franciscoruiz.workouts.step_exercises.application.StepExerciseResponse;
import ar.franciscoruiz.workouts.step_exercises.domain.StepExerciseId;
import ar.franciscoruiz.workouts.step_exercises.domain.StepExerciseNotExist;
import ar.franciscoruiz.workouts.step_exercises.domain.StepExerciseRepository;

@Service
public final class StepExerciseFinder {
    private final StepExerciseRepository repository;
    private final QueryBus               queryBus;

    public StepExerciseFinder(StepExerciseRepository repository, QueryBus queryBus) {
        this.repository = repository;
        this.queryBus   = queryBus;
    }

    public StepExerciseResponse find(StepExerciseId id) {
        return this.repository.search(id)
            .map((stepExercise) -> new StepExerciseResponse(
                stepExercise.id().value(),
                stepExercise.series().value(),
                stepExercise.value().value(),
                stepExercise.timeUnit().toString(),
                stepExercise.stepId().value(),
                findExercise(stepExercise.exerciseId())
            ))
            .orElseThrow(() -> new StepExerciseNotExist(id));
    }

    private ExerciseResponse findExercise(ExerciseId id) {
        return this.queryBus.ask(new FindExerciseQuery(id.value()));
    }
}
