package ar.franciscoruiz.workouts.step_types.application.find;

import ar.franciscoruiz.shared.domain.bus.query.Query;

public final class FindStepTypeQuery implements Query {
    private final String id;

    public FindStepTypeQuery(String id) {
        this.id = id;
    }

    public String id() {
        return id;
    }
}
