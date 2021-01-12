package ar.franciscoruiz.workouts.step_exercises.domain;

import ar.franciscoruiz.shared.domain.vo.IntValueObject;

public final class StepExerciseValue extends IntValueObject {
    public StepExerciseValue(Integer value) {
        super(value);
    }

    public StepExerciseValue() {
        super(null);
    }
}
