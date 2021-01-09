package ar.franciscoruiz.workouts.workout_exercises.domain;

import ar.franciscoruiz.shared.domain.DomainError;

public final class WorkoutExerciseNotExist extends DomainError {
    public WorkoutExerciseNotExist(WorkoutExerciseId id) {
        super("workout_exercise_not_exist", String.format("The workout exercise <%s> doesn't exist", id.value()));
    }
}
