package ar.franciscoruiz.workouts.step_types.application;

import ar.franciscoruiz.shared.domain.bus.query.Response;
import ar.franciscoruiz.workouts.step_types.domain.StepType;

public final class StepTypeResponse implements Response {
    private final String id;
    private final String description;
    private final String language;

    public StepTypeResponse(String id, String description, String language) {
        this.id          = id;
        this.description = description;
        this.language    = language;
    }

    public static StepTypeResponse fromAggregate(StepType entity) {
        return new StepTypeResponse(entity.id().value(), entity.description().value(), entity.language().value());
    }

    public String id() {
        return this.id;
    }

    public String description() {
        return this.description;
    }

    public String language() {
        return this.language;
    }
}
