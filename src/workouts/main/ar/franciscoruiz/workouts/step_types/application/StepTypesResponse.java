package ar.franciscoruiz.workouts.step_types.application;

import ar.franciscoruiz.shared.domain.bus.query.Response;

import java.util.List;

public final class StepTypesResponse implements Response {
    private final List<StepTypeResponse> values;

    public StepTypesResponse(List<StepTypeResponse> values) {
        this.values = values;
    }

    public List<StepTypeResponse> values() {
        return this.values;
    }
}
