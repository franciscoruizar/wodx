package ar.franciscoruiz.workouts.step_exercises.application.create;


import ar.franciscoruiz.shared.domain.Service;
import ar.franciscoruiz.workouts.exercises.domain.ExerciseId;
import ar.franciscoruiz.workouts.step_exercises.domain.*;
import ar.franciscoruiz.workouts.steps.domain.StepId;

@Service
public final class StepExerciseCreator {
    private final StepExerciseRepository repository;

    public StepExerciseCreator(StepExerciseRepository repository) {
        this.repository = repository;
    }

    public void create(
        StepExerciseId id,
        StepExerciseSeries series,
        StepExerciseValue value,
        StepExerciseTimeUnit timeUnit,
        StepId stepId,
        ExerciseId exerciseId
    ) {
        StepExercise stepExercise = new StepExercise(id, series, value, timeUnit, stepId, exerciseId);

        this.repository.save(stepExercise);
    }
}
