package ar.franciscoruiz.workouts.step_types.application;

import ar.franciscoruiz.shared.domain.bus.query.Response;
import ar.franciscoruiz.workouts.step_types.domain.StepType;

public final class StepTypeResponse implements Response {
    private final String id;
    private final String description;

    public StepTypeResponse(String id, String description) {
        this.id          = id;
        this.description = description;
    }

    public static StepTypeResponse fromAggregate(StepType entity) {
        return new StepTypeResponse(entity.id(), entity.description());
    }

    public String id() {
        return this.id;
    }

    public String description() {
        return this.description;
    }
}
