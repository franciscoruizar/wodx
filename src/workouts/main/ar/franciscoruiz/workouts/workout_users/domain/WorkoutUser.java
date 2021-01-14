package ar.franciscoruiz.workouts.workout_users.domain;

import ar.franciscoruiz.shared.domain.users.UserId;
import ar.franciscoruiz.workouts.workouts.domain.WorkoutId;

import java.util.Objects;

public final class WorkoutUser {
    private final String id;
    private final String     workoutId;
    private final String        athleteId;

    public WorkoutUser(String id, String workoutId, String athleteId) {
        this.id        = id;
        this.workoutId = workoutId;
        this.athleteId = athleteId;
    }

    public WorkoutUser() {
        this.id        = null;
        this.workoutId = null;
        this.athleteId = null;
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
