package ar.franciscoruiz.workouts.steps.application.find;

import ar.franciscoruiz.shared.domain.bus.query.Query;

public final class FindStepQuery implements Query {
    private final String id;

    public FindStepQuery(String id) {
        this.id = id;
    }

    public String id() {
        return id;
    }
}
