package ar.franciscoruiz.workouts.exercises.domain;

import ar.franciscoruiz.shared.domain.vo.StringValueObject;

public final class ExerciseDescription extends StringValueObject {
    public ExerciseDescription(String value) {
        super(value);
    }

    private ExerciseDescription() {
        super(null);
    }
}
