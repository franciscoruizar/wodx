package ar.franciscoruiz.workouts.workout_exercises.domain;

import ar.franciscoruiz.shared.domain.vo.IntValueObject;

public final class WorkoutExerciseSeries extends IntValueObject {
    public WorkoutExerciseSeries(Integer value) {
        super(value);
    }

    private WorkoutExerciseSeries() {
        super(null);
    }
}
