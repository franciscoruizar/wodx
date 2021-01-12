package ar.franciscoruiz.workouts.workout_users.application;

import ar.franciscoruiz.shared.domain.bus.query.Query;
import ar.franciscoruiz.workouts.workout_users.domain.WorkoutUser;

public final class WorkoutUserResponse implements Query {
    private final String id;
    private final String workoutId;
    private final String athleteId;

    public WorkoutUserResponse(String id, String workoutId, String athleteId) {
        this.id        = id;
        this.workoutId = workoutId;
        this.athleteId = athleteId;
    }

    public static WorkoutUserResponse fromAggregate(WorkoutUser entity) {
        return new WorkoutUserResponse(
            entity.id().value(),
            entity.workoutId().value(),
            entity.athleteId().value()
        );
    }

    public String id() {
        return this.id;
    }

    public String workoutId() {
        return this.workoutId;
    }

    public String athleteId() {
        return this.athleteId;
    }


}
