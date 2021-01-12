package ar.franciscoruiz.workouts.step_exercises.domain;

import ar.franciscoruiz.shared.domain.vo.IntValueObject;

public final class StepExerciseSeries extends IntValueObject {
    public StepExerciseSeries(Integer value) {
        super(value);
    }

    private StepExerciseSeries() {
        super(null);
    }
}
