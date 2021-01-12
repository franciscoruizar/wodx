package ar.franciscoruiz.workouts.workouts.domain;

import ar.franciscoruiz.shared.domain.DomainError;

public final class WorkoutNotExist extends DomainError {
    public WorkoutNotExist(WorkoutId id) {
        super("workout_not_exist", String.format("The workout <%s> doesn't exist", id.value()));
    }
}
