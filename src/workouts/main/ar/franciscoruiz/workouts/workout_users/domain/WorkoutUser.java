package ar.franciscoruiz.workouts.workout_users.domain;

import ar.franciscoruiz.shared.domain.users.UserId;
import ar.franciscoruiz.workouts.workouts.domain.WorkoutId;

import java.util.Objects;

public final class WorkoutUser {
    private final WorkoutUserId id;
    private final WorkoutId     workoutId;
    private final UserId        athleteId;

    public WorkoutUser(WorkoutUserId id, WorkoutId workoutId, UserId athleteId) {
        this.id        = id;
        this.workoutId = workoutId;
        this.athleteId = athleteId;
    }

    public WorkoutUser() {
        this.id        = null;
        this.workoutId = null;
        this.athleteId = null;
    }

    public WorkoutUserId id() {
        return this.id;
    }

    public WorkoutId workoutId() {
        return this.workoutId;
    }

    public UserId athleteId() {
        return this.athleteId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WorkoutUser that = (WorkoutUser) o;
        return Objects.equals(id, that.id) && Objects.equals(workoutId, that.workoutId) && Objects.equals(athleteId, that.athleteId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, workoutId, athleteId);
    }
}
