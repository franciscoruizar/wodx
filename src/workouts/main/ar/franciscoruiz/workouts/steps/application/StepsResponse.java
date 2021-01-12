package ar.franciscoruiz.workouts.steps.application;

import ar.franciscoruiz.shared.domain.bus.query.Response;

import java.util.List;

public final class StepsResponse implements Response {
    private final List<StepResponse> values;

    public StepsResponse(List<StepResponse> values) {
        this.values = values;
    }

    public List<StepResponse> values() {
        return this.values;
    }
}
