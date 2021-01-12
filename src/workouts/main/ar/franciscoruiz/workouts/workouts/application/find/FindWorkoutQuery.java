package ar.franciscoruiz.workouts.workouts.application.find;

import ar.franciscoruiz.shared.domain.bus.query.Query;

public final class FindWorkoutQuery implements Query {
    private final String id;

    public FindWorkoutQuery(String id) {
        this.id = id;
    }

    public String id() {
        return id;
    }
}
