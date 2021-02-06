package ar.franciscoruiz.workouts.workouts.domain;

import ar.franciscoruiz.shared.domain.UuidMother;

public final class WorkoutIdMother {
    public static WorkoutId create(String value) {
        return new WorkoutId(value);
    }

    public static WorkoutId random() {
        return create(UuidMother.random());
    }
}
