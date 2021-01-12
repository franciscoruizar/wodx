package ar.franciscoruiz.workouts.step_exercises.application.find;

import ar.franciscoruiz.shared.domain.bus.query.Query;

public final class FindStepExerciseQuery implements Query {
    private final String id;

    public FindStepExerciseQuery(String id) {
        this.id = id;
    }

    public String id() {
        return id;
    }
}
