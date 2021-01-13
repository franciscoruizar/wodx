package ar.franciscoruiz.workouts.step_exercises.application;

import ar.franciscoruiz.shared.domain.bus.query.Response;

import java.util.List;

public final class StepExercisesResponse implements Response {
    private final List<StepExerciseResponse> values;

    public StepExercisesResponse(List<StepExerciseResponse> values) {
        this.values = values;
    }

    public List<StepExerciseResponse> values() {
        return this.values;
    }
}
