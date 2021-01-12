package ar.franciscoruiz.workouts.step_exercises.domain;

import ar.franciscoruiz.shared.domain.DomainError;

public final class StepExerciseNotExist extends DomainError {
    public StepExerciseNotExist(StepExerciseId id) {
        super("workout_exercise_not_exist", String.format("The workout exercise <%s> doesn't exist", id.value()));
    }
}
