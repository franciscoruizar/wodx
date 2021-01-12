package ar.franciscoruiz.workouts.workout_users.application;

import ar.franciscoruiz.shared.domain.bus.query.Response;

import java.util.List;

public final class WorkoutUsersResponse implements Response {
    private final List<WorkoutUserResponse> values;

    public WorkoutUsersResponse(List<WorkoutUserResponse> values) {
        this.values = values;
    }

    public List<WorkoutUserResponse> values() {
        return this.values;
    }
}
