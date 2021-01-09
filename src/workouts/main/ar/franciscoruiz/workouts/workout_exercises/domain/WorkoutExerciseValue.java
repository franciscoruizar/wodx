package ar.franciscoruiz.workouts.workout_exercises.domain;

import ar.franciscoruiz.shared.domain.vo.IntValueObject;

public final class WorkoutExerciseValue extends IntValueObject {
    public WorkoutExerciseValue(Integer value) {
        super(value);
    }

    public WorkoutExerciseValue() {
        super(null);
    }
}
