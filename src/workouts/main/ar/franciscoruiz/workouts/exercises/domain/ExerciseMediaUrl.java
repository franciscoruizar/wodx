package ar.franciscoruiz.workouts.exercises.domain;

import ar.franciscoruiz.shared.domain.vo.StringValueObject;

public final class ExerciseMediaUrl extends StringValueObject {
    public ExerciseMediaUrl(String value) {
        super(value);
    }

    private ExerciseMediaUrl() {
        super(null);
    }
}
