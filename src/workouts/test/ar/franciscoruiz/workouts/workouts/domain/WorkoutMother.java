package ar.franciscoruiz.workouts.workouts.domain;

import ar.franciscoruiz.shared.domain.DateTimeMother;
import ar.franciscoruiz.shared.domain.users.UserId;
import ar.franciscoruiz.shared.domain.users.UserIdMother;

import java.time.LocalDateTime;

public final class WorkoutMother {
    public static Workout create(WorkoutId id, LocalDateTime startDate, LocalDateTime endDate, UserId coachId) {
        return new Workout(id, startDate, endDate, coachId);
    }

    public static Workout random() {
        return create(WorkoutIdMother.random(), DateTimeMother.random(), DateTimeMother.random(), UserIdMother.random());
    }
}
