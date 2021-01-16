package ar.franciscoruiz.workouts.step_exercises.application.find;

import ar.franciscoruiz.shared.domain.bus.query.QueryHandler;
import ar.franciscoruiz.workouts.step_exercises.application.StepExerciseResponse;
import ar.franciscoruiz.workouts.step_exercises.domain.StepExerciseId;
import ar.franciscoruiz.workouts.step_exercises.domain.StepExerciseNotExist;

public final class FindStepExerciseQueryHandler implements QueryHandler<FindStepExerciseQuery, StepExerciseResponse> {
    private final StepExerciseFinder finder;

    public FindStepExerciseQueryHandler(StepExerciseFinder finder) {
        this.finder = finder;
    }

    @Override
    public StepExerciseResponse handle(FindStepExerciseQuery query) throws StepExerciseNotExist {
        return finder.find(new StepExerciseId(query.id()));
    }
}
