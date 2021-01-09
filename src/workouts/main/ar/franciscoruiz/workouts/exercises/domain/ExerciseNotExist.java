package ar.franciscoruiz.workouts.exercises.domain;

import ar.franciscoruiz.shared.domain.DomainError;

public final class ExerciseNotExist extends DomainError {
    public ExerciseNotExist(ExerciseId id) {
        super("exercise_not_exist", String.format("The exercise <%s> doesn't exist", id.value()));
    }
}
