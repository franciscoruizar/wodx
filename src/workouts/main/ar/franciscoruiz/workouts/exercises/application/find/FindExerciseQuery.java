package ar.franciscoruiz.workouts.exercises.application.find;

import ar.franciscoruiz.shared.domain.bus.query.Query;

public final class FindExerciseQuery implements Query {
    private final String id;

    public FindExerciseQuery(String id) {
        this.id = id;
    }

    public String id() {
        return id;
    }
}
