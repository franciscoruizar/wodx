package ar.franciscoruiz.workouts.workouts.domain;

import ar.franciscoruiz.shared.domain.users.UserId;

import java.time.LocalDateTime;
import java.util.Objects;

public final class Workout {
    private final WorkoutId     id;
    private final LocalDateTime startDate;
    private final LocalDateTime endDate;
    private final UserId        coachId;

    public Workout(WorkoutId id, LocalDateTime startDate, LocalDateTime endDate, UserId coachId) {
        this.id        = id;
        this.startDate = startDate;
        this.endDate   = endDate;
        this.coachId   = coachId;
    }

    public Workout() {
        this.id        = null;
        this.startDate = null;
        this.endDate   = null;
        this.coachId   = null;
    }

    public WorkoutId id() {
        return this.id;
    }

    public LocalDateTime startDate() {
        return this.startDate;
    }

    public LocalDateTime endDate() {
        return this.endDate;
    }

    public UserId coachId() {
        return this.coachId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Workout workout = (Workout) o;
        return Objects.equals(id, workout.id) && Objects.equals(startDate, workout.startDate) && Objects.equals(endDate, workout.endDate) && Objects.equals(coachId, workout.coachId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, startDate, endDate, coachId);
    }
}
