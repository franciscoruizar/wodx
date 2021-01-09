package ar.franciscoruiz.workouts.workout_users.domain;

import ar.franciscoruiz.shared.domain.DomainError;

public final class WorkoutUserNotExist extends DomainError {
    public WorkoutUserNotExist(WorkoutUserId id) {
        super("workout_user_not_exist", String.format("The workout user <%s> doesn't exist", id.value()));
    }
}
